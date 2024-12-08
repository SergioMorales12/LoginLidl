package com.example.login.navigation

// Almacena la ruta de las dos ventanas
sealed class AppScreen(val route : String) {
    object FirstScreen: AppScreen("FirstScreen")
    object SecondScreen: AppScreen("SecondScreen")
}