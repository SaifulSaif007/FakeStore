package com.saiful.fakestore.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.*
import com.saiful.fakestore.ui.login.LoginScreen
import com.saiful.fakestore.ui.product.ProductScreen
import com.saiful.fakestore.ui.theme.FakeStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FakeStoreTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable(route = "login") {
                        LoginScreen {
                            navController.navigate("product")
                        }
                    }

                    composable(route = "product") {
                        ProductScreen()
                    }
                }

            }
        }
    }
}

