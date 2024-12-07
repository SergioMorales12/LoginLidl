package com.example.login.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.bodys.BodyLogin
import com.example.login.header.Header
import com.example.login.LoginViewModel
import com.example.login.bodys.BodyLoged

@Composable
fun FirstScreen(navController: NavController, modifier: Modifier , viewModel: LoginViewModel){
    FirstBody(navController,modifier, viewModel)

}

@Composable
fun FirstBody(navController: NavController, modifier: Modifier,viewModel: LoginViewModel){


        // Obtenemos el estado desde el ViewModel
        val username = viewModel.username.value
        val password = viewModel.password.value
        val isLoggedIn = viewModel.isLoggedIn.value
        val passwordVisibility = viewModel.passwordVisibility.value



        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoggedIn) {
                // Pantalla de bienvenida después del inicio de sesión
                Text(
                    text = "Bienvenido, $username!",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                BodyLoged(username, viewModel)

            } else {

                Header()

                BodyLogin(
                    viewModel,
                    username,
                    password,
                    passwordVisibility,
                    navController
                )
            }
        }
    }

//                onClick = { NavController.navigate(route = com.example.login.navigation.AppScreen.route + "/$list") }



