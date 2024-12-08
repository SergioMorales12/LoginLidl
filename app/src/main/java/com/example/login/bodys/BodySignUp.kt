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
import androidx.compose.material3.Checkbox
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

// Composable para crear una nueva cuenta de usuario
@Composable
fun BodySignUp(
    viewModel: LoginViewModel,  // ViewModel para gestionar los cambios en los campos y el estado de la sesión
    username: String,  // Nombre de usuario ingresado
    confirmUsername: String,  // Confirmación del nombre de usuario
    password: String,  // Contraseña ingresada
    confirmPassword: String,  // Confirmación de la contraseña
    passwordVisibility: Boolean,  // Estado para mostrar/ocultar la contraseña
    passwordConfirmVisibility: Boolean,  // Estado para mostrar/ocultar la confirmación de la contraseña
    isChecked: Boolean,  // Estado de los checkboxes (aceptación de políticas y suscripción)
    navController: NavController  // Controlador de navegación para navegar entre pantallas
) {
    // Usamos LazyColumn para una lista de elementos, adecuada para pantallas con mucho contenido
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {

            // Caja de descuento (asumida desde otro Composable)
            BoxDescuento()

            // Título de la pantalla
            TextoGrande("Crear una cuenta")

            // Etiqueta de email
            TextoMediano("E-mail")

            // Campo de texto para el nombre de usuario
            OutlinedTextField(
                value = username,
                onValueChange = { viewModel.onUsernameChanged(it) },  // Actualiza el valor en el ViewModel
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, start = 10.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Etiqueta para confirmar el email
            TextoMediano("Confirmar E-mail")

            // Campo de texto para la confirmación del nombre de usuario
            OutlinedTextField(
                value = confirmUsername,
                onValueChange = { viewModel.onConfirmUsernameChanged(it) },
                isError = viewModel.confirmUsernameError(),  // Muestra error si no coinciden
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, start = 10.dp)
            )

            // Mensaje de error si los emails no coinciden
            if (!viewModel.confirmUsernameError()) {
                Text(
                    text = "La confirmación del usuario no coincide",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Etiqueta para la contraseña
            TextoMediano("Contraseña")

            // Campo de texto para la contraseña
            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onPasswordChanged(it) },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {  // Icono para mostrar u ocultar la contraseña
                    IconButton(
                        onClick = { viewModel.togglePasswordVisibility() }
                    ) {
                        Icon(
                            imageVector = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordVisibility) "Ocultar contraseña" else "Mostrar contraseña"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, start = 10.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Etiqueta para la confirmación de la contraseña
            TextoMediano("Confirmar Contraseña")

            // Campo de texto para confirmar la contraseña
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { viewModel.onConfirmPasswordChanged(it) },
                visualTransformation = if (passwordConfirmVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(
                        onClick = { viewModel.toggleConfirmPasswordVisibility() }
                    ) {
                        Icon(
                            imageVector = if (passwordConfirmVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordConfirmVisibility) "Ocultar contraseña" else "Mostrar contraseña"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isError = viewModel.confirmPasswordError(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, start = 10.dp)
            )

            // Mensaje de error si las contraseñas no coinciden
            if (!viewModel.confirmPasswordError()) {
                Text(
                    text = "La confirmación de la contraseña no coincide",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                )
            }

            // Texto de CAPTCHA o validación adicional (asumido como componente adicional)
            TextoCaptcha()

            // Checkbox para autorización de tratamiento de datos
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { viewModel.toggleIsChecked() }  // Actualiza el estado del checkbox
                )
                Text(
                    text = "Autorizo el tratamiento de mis datos para gestionar la tramitación de mis pedidos.",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Checkbox para suscripción a la Newsletter de Lidl
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { viewModel.toggleIsChecked() }
                )
                Text(
                    text = "Sí, deseo suscribirme a la Newsletter de Lidl Supermercados, SAU con información adaptada a mí sobre la base de un perfil de usuario personalizado acerca de los productos y las promociones de las empresas asociadas al grupo Lidl.",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para crear la cuenta
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { viewModel.addSession() },  // Llama a la función para agregar una nueva sesión
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(125.dp)
                        .background(Color.Blue),
                    colors = ButtonDefaults.buttonColors(
                        Color.Blue
                    ),
                    contentPadding = PaddingValues(5.dp)
                ) {
                    Text(
                        text = "CREAR CUENTA",
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier.padding(0.dp)
                    )
                }

                Spacer(modifier = Modifier.width(15.dp))

                // Texto que permite redirigir a la pantalla de login si ya tiene cuenta
                ClickableText(
                    text = AnnotatedString("¿Tienes cuenta? ¡Inicia Sesión YAA!"),
                    onClick = {
                        navController.navigate(route = AppScreen.FirstScreen.route)
                    },
                    style = TextStyle(
                        color = Color.Gray,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 16.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Texto largo (componente adicional asumido)
            TextoLargo()

            // Footer de la pantalla (componente adicional asumido)
            Footer()
        }
    }
}
