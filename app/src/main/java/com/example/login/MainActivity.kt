package com.example.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ViewHeadline
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    // Obtenemos el estado desde el ViewModel
    val viewModel: LoginViewModel = LoginViewModel()
    val username by viewModel.username//.observeAsState("")
    val password by viewModel.password
    val isLoggedIn by viewModel.isLoggedIn
    val passwordVisibility by viewModel.passwordVisibility

    Column(
        modifier = Modifier
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
            Button(
                onClick = { viewModel.logout() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cerrar sesión")
            }
        } else {
            // Pantalla de formulario de inicio de sesión

            Header()


            BodyLogin(viewModel,username,password,passwordVisibility)

            Footer()

        }
    }
}

@Composable
fun BodyLogin(viewModel: LoginViewModel, username: String, password: String, passwordVisibility: Boolean){
//    Column(
//        modifier = Modifier
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {

    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(50.dp)
        ,contentAlignment = Alignment.Center
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
            onValueChange = { viewModel.onUsernameChanged(it) },
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
            withStyle(style = SpanStyle(color = Color.Blue,fontSize = 15.sp, textDecoration = TextDecoration.Underline)){
                append("Política de Privacidad")
            }
            append(" y se aplica la ")
            withStyle(style = SpanStyle(color = Color.Blue,fontSize = 15.sp, textDecoration = TextDecoration.Underline)){
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

        Text(
            text = "¿Aún no tienes cuenta?¡Regístrate!",
            color = Color.Gray,
            style = MaterialTheme.typography.labelLarge,
            textDecoration = TextDecoration.Underline
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



}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.lidl),
            contentDescription = "Logo del Lidl",
            modifier = Modifier
                .size(55.dp)
                .padding(start = 6.dp)
        )

        Spacer(modifier = Modifier.width(6.dp))

        Column(
        ) {
            Icon(
                imageVector = Icons.Filled.Menu ,
                modifier = Modifier.size(40.dp),
                contentDescription = "Menu HAMBURGESA"
            )
            Text(
                text = "MENÚ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Filled.Newspaper,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 5.dp),
                contentDescription = "Novedades"
            )
            Icon(
                imageVector = Icons.Filled.Shop,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 5.dp),
                contentDescription = "Tienda"
            )
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 5.dp),
                contentDescription = "Perfil"
            )
            Icon(
                imageVector = Icons.Filled.HeartBroken,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 5.dp),
                contentDescription = "Lista de deseos"
            )
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 5.dp),
                contentDescription = "Carrito"
            )
        }


    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = "Buscar",
            onValueChange = {  },
            modifier = Modifier
                .padding(end = 10.dp, start = 10.dp)

        )
        Button(
            onClick = {  },
            modifier = Modifier
                .width(125.dp).padding(end = 10.dp)
                .background(Color.Blue),
            colors = ButtonDefaults.buttonColors(
                Color.Blue
            ),
            contentPadding = PaddingValues(
                5.dp
            )
        ) {

            Text(
                "BUSCAR",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier.padding(0.dp)
            )
        }
    }
    Row(
        horizontalArrangement = Arrangement.Absolute.Left
    ) {
        Text(text = "Compra Online", fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        Text(text ="En tu tienda", fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        Text(text ="Lidl Plus", fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        Text(text ="Recetas", fontSize = 15.sp, modifier = Modifier.padding(10.dp))


    }
}

@Composable
fun Footer(){
    Row(modifier = Modifier
        .fillMaxWidth()) {
    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = "Footer",
        modifier = Modifier
            .fillMaxWidth()
    )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header()
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
