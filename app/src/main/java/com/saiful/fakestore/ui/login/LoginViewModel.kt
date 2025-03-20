package com.saiful.fakestore.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saiful.fakestore.data.model.login.LoginRequest
import com.saiful.fakestore.data.repository.RepositoryImpl
import com.saiful.fakestore.network.ApiService
import com.saiful.fakestore.network.ktorClient
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val navigateToProduct = MutableSharedFlow<Boolean>()

    private val repository = RepositoryImpl(
        ApiService(ktorClient)
    )

    fun login() {
        viewModelScope.launch {
            val result = repository.login(
                LoginRequest(
                    username = "johnd",
                    password = "m38rmF$"
                )
            )

            if (result.isSuccess) {
                navigateToProduct.emit(true)
            }
        }
    }
}