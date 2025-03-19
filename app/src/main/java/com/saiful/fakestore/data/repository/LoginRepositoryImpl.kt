package com.saiful.fakestore.data.repository

import com.saiful.fakestore.data.model.LoginRequest
import com.saiful.fakestore.data.model.LoginResponse
import com.saiful.fakestore.domain.repository.LoginRepository
import com.saiful.fakestore.network.ApiService
import io.ktor.client.call.body

class LoginRepositoryImpl(private val apiService: ApiService) : LoginRepository {

    override suspend fun login(loginRequest: LoginRequest): Result<LoginResponse> {
        return try {
            Result.success(apiService.loginUser(loginRequest).body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}