package com.saiful.fakestore.data.model.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val token: String
)