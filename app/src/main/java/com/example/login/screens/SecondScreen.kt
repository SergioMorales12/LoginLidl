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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.login.bodys.BodySignUp
import com.example.login.header.Header
import com.example.login.LoginViewModel


@Composable
fun SecondScreen(navController: NavController, modifier: Modifier, viewModel: LoginViewModel){
    SecondBody(navController,modifier,viewModel )
}

@Composable
fun SecondBody(navController: NavController, modifier: Modifier, viewModel: LoginViewModel){

    // Obtenemos el estado desde el ViewModel
    val username by rememberSaveable { viewModel.username }
    val password by rememberSaveable { viewModel.password }
    val isChecked by rememberSaveable { viewModel.isChecked }

    val confirmUsername by rememberSaveable { viewModel.confirmUsername }
    val confirmPassword by rememberSaveable { viewModel.confirmPassword }

    val passwordVisibility by rememberSaveable { viewModel.passwordVisibility }
    val passwordConfirmVisibility by rememberSaveable { viewModel.passwordConfirmVisibility }



    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Pantalla de formulario de crear una cuenta
        Header()

        BodySignUp(
            viewModel,
            username,
            confirmUsername,
            password,
            confirmPassword,
            passwordVisibility,
            passwordConfirmVisibility,
            isChecked,
            navController
        )

    }
}


