package com.saiful.fakestore.network

import com.saiful.fakestore.data.model.LoginRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.*

class ApiService(private val client: HttpClient) {

    suspend fun loginUser(loginRequest: LoginRequest) = client.post(EndPoints.LOGIN){
        setBody(loginRequest)
    }

}

object EndPoints {

    private const val BASE_URL = "https://fakestoreapi.com/"

    const val LOGIN = "${BASE_URL}auth/login"

}