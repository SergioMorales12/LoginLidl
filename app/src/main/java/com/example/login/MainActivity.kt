package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.example.login.navigation.AppNavigation
import com.example.login.ui.theme.LoginTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = LoginViewModel()
                    AppNavigation(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}



