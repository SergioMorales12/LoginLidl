package com.example.login.bodys

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login.LoginViewModel
import com.example.login.R
import com.example.login.navigation.AppScreen

@Composable
fun BodyLogin(viewModel: LoginViewModel, username: String, password: String, passwordVisibility: Boolean,navController: NavController){

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {

            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxWidth()
                    .height(50.dp), contentAlignment = Alignment.Center
            )

            {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        color = Color.White,
                        modifier = Modifier.padding(start = 10.dp),
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 15.sp))
                            {
                                append("-15%")
                            }
                            append(" de descuento extra en JUGUETES con el código ")
                            withStyle(style = SpanStyle(fontSize = 15.sp)) {
                                append("JUGUETESDICIENBRE")
                            }
                        }
                    )
                }
            }


            Text(
                "Identifícate",
                style = MaterialTheme.typography.labelLarge,
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 35.sp

            )
            Text(
                "E-mail",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 20.dp),
                fontSize = 15.sp
            )
            OutlinedTextField(
                value = username,
                onValueChange = { viewModel.onUsernameChanged(it)   },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, start = 10.dp)

            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Contraseña",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                fontSize = 15.sp
            )
            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onPasswordChanged(it) },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
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
            Text(
                text = buildAnnotatedString {
                    append("Esta página está protegida por reCAPTCHA y se aplica la ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Política de Privacidad")
                    }
                    append(" y se aplica la ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Términos de Servicio ")
                    }
                    append("de Google")
                },
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            )
            Text(
                text = "¿Has olvidado la contraseña?",
                color = Color.Gray,
                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                fontSize = 15.sp

            )

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { viewModel.login() },
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(125.dp)
                        .background(Color.Blue),
                    colors = ButtonDefaults.buttonColors(
                        Color.Blue
                    ),
                    contentPadding = PaddingValues(
                        5.dp
                    )
                ) {

                    Text(
                        "INICIAR SESIÓN",
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier.padding(0.dp)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))



                ClickableText(
                    text = AnnotatedString("¿Aún no tienes cuenta? ¡Regístrate!"),
                    onClick = {
                        navController.navigate(route = AppScreen.SecondScreen.route)
                    },
                    style = TextStyle(
                        color = Color.Gray,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 16.sp
                    )
                )

            }
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "De momento no realizamos envíos a Ceuta y Melilla.\n" +
                        "En los pedidos a Islas Baleares el tiempo de entrega incrementará en 24 horas.En los pedidos a Islas Canarias el tiempo de entrega será entre 5 y 12 días laborables desde la fecha del pedido. Gastos de envío gratuitos a partir de 79 Euros solo aplicable a Península y Baleares.\n" +
                        "\n" +
                        "*Todos los precios están indicados en Euros y no incluyen decoración. Precio recomendado o PVPR es el precio al que el fabricante recomienda vender el producto y que ha sido proporcionado por el fabricante, distribuidor u otro vendedor.",
                modifier = Modifier.padding(10.dp)
            )
            Box(modifier = Modifier
                .fillMaxSize()) {

                // Imagen que ocupa toda la caja
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Footer Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop // Opcion para que la imagen ocupe toda la caja
                )
            }

        }
    }


}