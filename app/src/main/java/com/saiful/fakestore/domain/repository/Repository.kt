package com.saiful.fakestore.domain.repository

import com.saiful.fakestore.data.model.login.LoginRequest
import com.saiful.fakestore.data.model.login.LoginResponse
import com.saiful.fakestore.data.model.product.ProductResponse

interface Repository {
    suspend fun login(loginRequest: LoginRequest): Result<LoginResponse>

    suspend fun getProducts(): Result<List<ProductResponse>>
}