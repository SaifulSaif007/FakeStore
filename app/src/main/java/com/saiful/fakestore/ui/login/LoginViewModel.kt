package com.saiful.fakestore.ui.login

import androidx.lifecycle.ViewModel
import com.saiful.fakestore.data.model.LoginRequest
import com.saiful.fakestore.data.repository.LoginRepositoryImpl
import com.saiful.fakestore.network.ApiService
import com.saiful.fakestore.network.ktorClient
import kotlinx.coroutines.runBlocking

class LoginViewModel() {

    private val repository = LoginRepositoryImpl(
        ApiService(ktorClient)
    )

    fun login() {
        runBlocking {
            repository.login(
                LoginRequest(
                    username = "johnd",
                    password = "m38rmF$"
                )

            )
        }
    }
}