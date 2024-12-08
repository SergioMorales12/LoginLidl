package com.example.login.bodys

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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

// Composable para mostrar la página de bienvenida tras un inicio de sesión exitoso
@Composable
fun BodyLoged(
    name: String,  // Nombre del usuario que ha iniciado sesión
    viewModel: LoginViewModel  // ViewModel para gestionar el estado de la sesión
) {
    // Componente Header, probablemente con información como el título o icono de la app
    Header()

    // Box para centrar el contenido en la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize(),  // Rellena toda la pantalla
        contentAlignment = Alignment.Center  // Centra el contenido
    ) {
        // Columna que organiza los elementos de la interfaz en el centro
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,  // Centrado vertical
            horizontalAlignment = Alignment.CenterHorizontally  // Centrado horizontal
        ) {
            // Texto de bienvenida personalizado que incluye el nombre del usuario y un saludo
            Text(
                text = buildAnnotatedString {
                    // Estilo para el nombre del usuario (más pequeño)
                    withStyle(style = SpanStyle(fontSize = 15.sp)) {
                        append(name)  // Inserta el nombre del usuario
                    }
                    append(", Bienvenido a la familia ")  // Mensaje estático
                    // Estilo para el texto "LIDL" (más grande)
                    withStyle(style = SpanStyle(fontSize = 20.sp)) {
                        append("LIDL")  // Nombre de la empresa en mayor tamaño
                    }
                }
            )

            // Espaciador para separar el texto del botón
            Spacer(modifier = Modifier.height(16.dp))

            // Botón para cerrar sesión
            Button(
                onClick = { viewModel.logout() },  // Llama a la función logout del ViewModel al hacer clic
                modifier = Modifier.background(Color.Blue),  // Fondo azul para el botón
                colors = ButtonDefaults.buttonColors(Color.Blue)  // Color del botón
            ) {
                // Texto dentro del botón
                Text("Cerrar sesión", color = Color.White)  // Texto blanco dentro del botón
            }
        }
    }
}
