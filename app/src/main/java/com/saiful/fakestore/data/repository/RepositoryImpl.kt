package com.saiful.fakestore.data.repository

import com.saiful.fakestore.data.model.login.LoginRequest
import com.saiful.fakestore.data.model.login.LoginResponse
import com.saiful.fakestore.data.model.product.ProductResponse
import com.saiful.fakestore.domain.repository.Repository
import com.saiful.fakestore.network.ApiService
import io.ktor.client.call.body

class RepositoryImpl(private val apiService: ApiService) : Repository {

    override suspend fun login(loginRequest: LoginRequest): Result<LoginResponse> {
        return try {
            Result.success(apiService.loginUser(loginRequest).body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getProducts(): Result<List<ProductResponse>> {
        return try {
            Result.success(apiService.getProducts().body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}