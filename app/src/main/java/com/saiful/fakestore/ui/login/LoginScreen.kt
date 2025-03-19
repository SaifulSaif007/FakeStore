package com.saiful.fakestore.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.saiful.fakestore.data.repository.LoginRepositoryImpl

@Composable
fun LoginScreen() {
    LoginScreenContent()
}

@Composable
fun LoginScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val apiService = remember { LoginViewModel() }

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Username") }
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") }
        )

        OutlinedButton(
            onClick = {
                apiService.login()
            }
        ) {
            Text("Login")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LoginContentPreview() {
    LoginScreenContent()
}