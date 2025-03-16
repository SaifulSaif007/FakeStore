package com.saiful.fakestore.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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
            onClick = {}
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