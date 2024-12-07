package com.example.login.bodys

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.LoginViewModel
import com.example.login.header.Header

@Composable
fun BodyLoged(name: String, viewModel: LoginViewModel){
    Header()
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 15.sp))
                    {
                        append(name)
                    }
                    append(", Bienvenido a la familia")
                    withStyle(style = SpanStyle(fontSize = 20.sp)) {
                        append("LIDL")
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { viewModel.logout() },
                modifier = Modifier.background(Color.Blue),
                colors = ButtonDefaults.buttonColors(
                    Color.Blue
                )
            ) {
                Text("Cerrar sesión", color = Color.White)
            }
        }

    }


}