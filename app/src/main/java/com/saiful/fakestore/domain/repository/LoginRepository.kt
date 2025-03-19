package com.saiful.fakestore.domain.repository

import com.saiful.fakestore.data.model.LoginRequest
import com.saiful.fakestore.data.model.LoginResponse

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest): Result<LoginResponse>
}