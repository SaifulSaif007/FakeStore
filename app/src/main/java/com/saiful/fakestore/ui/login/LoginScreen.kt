package com.saiful.fakestore.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    navigateToProduct: () -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.navigateToProduct.onEach {
            if (it) {
                navigateToProduct()
            }
        }.collect()
    }

    LoginScreenContent(viewModel)
}

@Composable
fun LoginScreenContent(viewModel: LoginViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        OutlinedTextField(
            value = username.value,
            onValueChange = {
                username.value = it
            },
            label = { Text("Username") }
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            label = { Text("Password") }
        )

        OutlinedButton(
            onClick = {
                viewModel.login()
            },
            enabled = username.value.isNotBlank() && password.value.isNotBlank()
        ) {
            Text("Login")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LoginContentPreview() {
    LoginScreenContent(viewModel())
}