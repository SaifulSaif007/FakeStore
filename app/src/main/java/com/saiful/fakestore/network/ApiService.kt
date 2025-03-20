package com.saiful.fakestore.network

import com.saiful.fakestore.data.model.login.LoginRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.*

class ApiService(private val client: HttpClient) {

    suspend fun loginUser(loginRequest: LoginRequest) = client.post(EndPoints.LOGIN) {
        setBody(loginRequest)
    }

    suspend fun getProducts() = client.get(EndPoints.PRODUCTS)
}

object EndPoints {

    private const val BASE_URL = "https://fakestoreapi.com/"

    const val LOGIN = "${BASE_URL}auth/login"
    const val PRODUCTS = "${BASE_URL}products"

}