package com.example.login.bodys

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.LoginViewModel
import com.example.login.navigation.AppScreen

// Composable que representa el cuerpo del formulario de inicio de sesión
@Composable
fun BodyLogin(
    viewModel: LoginViewModel,  // ViewModel para gestionar los estados del formulario
    username: String,  // Nombre de usuario ingresado
    password: String,  // Contraseña ingresada
    passwordVisibility: Boolean,  // Estado de visibilidad de la contraseña
    navController: NavController  // Controlador de navegación para manejar la navegación entre pantallas
) {
    // Estructura principal del formulario usando LazyColumn para permitir desplazamiento
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Descuento visual o título adicional
            BoxDescuento()

            // Título principal
            TextoGrande("Identifícate")

            // Etiqueta para el campo de usuario
            TextoMediano("E-mail")

            // Campo de texto para ingresar el nombre de usuario
            OutlinedTextField(
                value = username,  // Valor actual del campo
                onValueChange = { viewModel.onUsernameChanged(it) },  // Acción al cambiar el valor
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, start = 10.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Etiqueta para el campo de contraseña
            TextoMediano("Contraseña")

            // Campo de texto para ingresar la contraseña
            OutlinedTextField(
                value = password,  // Valor actual de la contraseña
                onValueChange = { viewModel.onPasswordChanged(it) },  // Acción al cambiar la contraseña
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),  // Condición para mostrar u ocultar la contraseña
                isError = viewModel.confirmLogin(),  // Validación para mostrar error si el login falla
                trailingIcon = {
                    // Icono para alternar la visibilidad de la contraseña
                    IconButton(
                        onClick = { viewModel.togglePasswordVisibility() }
                    ) {
                        Icon(
                            imageVector = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordVisibility) "Ocultar contraseña" else "Mostrar contraseña"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),  // Configuración para el teclado de contraseñas
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, start = 10.dp)
            )

            // Mostrar mensaje de error si el login falla
            if (!viewModel.confirmLogin()) {
                Text(
                    text = "La cuenta no está registrada",  // Mensaje de error
                    color = MaterialTheme.colorScheme.error,  // Color de error
                    style = MaterialTheme.typography.bodySmall,  // Estilo de texto pequeño
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                )
            }

            // Texto adicional, como CAPTCHA o recordatorio
            TextoCaptcha()

            // Texto para recordar la opción de recuperación de contraseña
            TextoOlvidarContrasenia()

            Spacer(modifier = Modifier.height(16.dp))

            // Fila con el botón de inicio de sesión y el enlace a la pantalla de registro
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Botón para iniciar sesión
                Button(
                    onClick = { viewModel.login() },  // Acción de login al presionar el botón
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(125.dp)
                        .background(Color.Blue),  // Color de fondo azul
                    colors = ButtonDefaults.buttonColors(
                        Color.Blue
                    ),
                    contentPadding = PaddingValues(
                        5.dp
                    )
                ) {
                    // Texto dentro del botón
                    Text(
                        text = "INICIAR SESIÓN",
                        fontSize = 15.sp,  // Tamaño de fuente
                        color = Color.White,  // Color del texto
                        modifier = Modifier.padding(0.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Enlace para navegar a la pantalla de registro
                ClickableText(
                    text = AnnotatedString("¿Aún no tienes cuenta? ¡Regístrate!"),  // Texto del enlace
                    onClick = {
                        // Navegar a la pantalla de registro
                        navController.navigate(route = AppScreen.SecondScreen.route)
                    },
                    style = TextStyle(
                        color = Color.Gray,  // Color gris para el texto
                        textDecoration = TextDecoration.Underline,  // Subrayado para estilo de enlace
                        fontSize = 16.sp  // Tamaño de fuente
                    )
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            // Sección adicional con información o detalles
            TextoLargo()

            // Pie de página
            Footer()
        }
    }
}
