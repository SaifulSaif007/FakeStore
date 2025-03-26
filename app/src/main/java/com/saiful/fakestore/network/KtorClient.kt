package com.saiful.fakestore.network

import android.util.Log
import com.saiful.fakestore.domain.exception.*
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.io.IOException
import kotlinx.serialization.json.Json

private const val NETWORK_TIME_OUT = 6_000

val ktorClient = HttpClient(Android) {
    HttpResponseValidator {
        validateResponse {
            val statusCode = it.status.value
            if (statusCode != 200) {
                throw when (statusCode) {
                    401 -> UnauthorizedException()
                    404 -> NotFoundException()
                    500 -> ServerErrorException()
                    else -> UnknownException()
                }
            }
        }

        handleResponseExceptionWithRequest { cause, _ ->
            when (cause) {
                is DomainException -> throw cause
                else -> throw DomainException("Network error: ${cause.message}")
            }
        }
    }

    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                useAlternativeNames = true
                encodeDefaults = false
            }
        )
    }

    engine {
        // this: AndroidEngineConfig
        connectTimeout = NETWORK_TIME_OUT
        socketTimeout = NETWORK_TIME_OUT
        // proxy = ProxyBuilder.socks("127.0.0.1", 8080)
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.d("Logger Ktor =>", message)
            }
        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP status:", "${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header("Content-Type", "application/json")
    }

}