package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.LoginViewModel
import com.example.login.screens.FirstScreen
import com.example.login.screens.SecondScreen

// Se encarga de la navegacion de la app entre las 2 ventanas
@Composable
fun AppNavigation(modifier: Modifier,viewModel: LoginViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.FirstScreen.route
    ) {
        composable(AppScreen.FirstScreen.route) {
            FirstScreen(
                navController = navController,
                modifier = modifier,
                viewModel = viewModel
            )
        }
        composable(AppScreen.SecondScreen.route) {
            SecondScreen(
                navController = navController,
                modifier = modifier,
                viewModel = viewModel
            )
        }
    }
}
