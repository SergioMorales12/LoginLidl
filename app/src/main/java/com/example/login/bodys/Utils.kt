package com.example.login.bodys

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocalAirport
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R

// Composable que muestra una caja con un descuento.
@Composable
fun BoxDescuento(){
    Box(
        modifier = Modifier
            .background(Color.Blue) // Fondo azul
            .fillMaxWidth()          // Ocupa el ancho completo
            .height(50.dp),          // Altura de 50dp
        contentAlignment = Alignment.Center // Centra el contenido
    ) {
        Row(
            modifier = Modifier.fillMaxSize(), // Usa el tamaño completo disponible
            horizontalArrangement = Arrangement.Center, // Centra el texto
            verticalAlignment = Alignment.CenterVertically // Centra verticalmente
        ) {
            Text(
                color = Color.White, // Texto blanco
                modifier = Modifier.padding(start = 10.dp), // Espaciado a la izquierda
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontSize = 15.sp)) {
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
}

// Composable para mostrar texto grande, como en los encabezados de "Iniciar sesión".
@Composable
fun TextoGrande(string: String){
    Text(
        text = string, // Muestra el texto pasado como parámetro
        style = MaterialTheme.typography.labelLarge, // Usando estilo predefinido
        color = Color.Gray, // Color gris
        modifier = Modifier
            .fillMaxWidth() // Ocupa el ancho completo
            .padding(10.dp), // Espaciado de 10dp
        fontSize = 35.sp // Tamaño de fuente grande
    )
}

// Composable para mostrar texto mediano, típicamente usado para etiquetas sobre campos de texto.
@Composable
fun TextoMediano(string: String){
    Text(
        text = string, // Muestra el texto
        modifier = Modifier
            .fillMaxWidth() // Ocupa el ancho completo
            .padding(start = 10.dp, top = 20.dp), // Espaciado con margen
        fontSize = 15.sp // Tamaño de fuente mediano
    )
}

// Composable para mostrar el texto del captcha con enlaces a la política de privacidad y términos de servicio.
@Composable
fun TextoCaptcha(){
    Text(
        text = buildAnnotatedString {
            append("Esta página está protegida por reCAPTCHA y se aplica la ")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue, // Texto azul subrayado
                    fontSize = 15.sp,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Política de Privacidad")
            }
            append(" y se aplica la ")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue, // Texto azul subrayado
                    fontSize = 15.sp,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Términos de Servicio ")
            }
            append("de Google")
        },
        style = MaterialTheme.typography.bodySmall, // Estilo pequeño para texto
        modifier = Modifier
            .fillMaxWidth() // Ocupa el ancho completo
            .padding(start = 10.dp) // Espaciado izquierdo
    )
}

// Composable para mostrar un texto subrayado que pregunta por la contraseña olvidada.
@Composable
fun TextoOlvidarContrasenia(){
    Text(
        text = "¿Has olvidado la contraseña?", // Texto de la pregunta
        color = Color.Gray, // Color gris
        textDecoration = TextDecoration.Underline, // Subrayado
        style = MaterialTheme.typography.labelLarge, // Estilo de texto grande
        modifier = Modifier
            .fillMaxWidth() // Ocupa el ancho completo
            .padding(start = 10.dp, top = 10.dp), // Espaciado
        fontSize = 15.sp // Tamaño de fuente de 15dp
    )
}

// Composable que muestra información larga sobre el envío y precios.
@Composable
fun TextoLargo(){
    Text(
        "De momento no realizamos envíos a Ceuta y Melilla.\n" +
                "En los pedidos a Islas Baleares el tiempo de entrega incrementará en 24 horas. En los pedidos a Islas Canarias el tiempo de entrega será entre 5 y 12 días laborables desde la fecha del pedido. Gastos de envío gratuitos a partir de 79 Euros solo aplicable a Península y Baleares.\n" +
                "\n" +
                "*Todos los precios están indicados en Euros y no incluyen decoración. Precio recomendado o PVPR es el precio al que el fabricante recomienda vender el producto y que ha sido proporcionado por el fabricante, distribuidor u otro vendedor.",
        modifier = Modifier.padding(10.dp) // Añade espaciado alrededor del texto
    )
}

// Composable que muestra un footer con iconos y textos explicando beneficios como envíos gratuitos y financiación.
@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxSize() // Ocupa el tamaño completo disponible
            .height(350.dp) // Altura fija de 350dp
            .background(Color.LightGray) // Fondo gris claro
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth() // Ocupa el ancho completo
                .padding(16.dp) // Espaciado
                .align(Alignment.TopCenter), // Alineación en la parte superior
            verticalArrangement = Arrangement.spacedBy(32.dp), // Espaciado entre las filas
            horizontalAlignment = Alignment.CenterHorizontally // Alineación horizontal central
        ) {
            // Primer fila de beneficios (envíos gratuitos, devoluciones)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Filled.LocalShipping,
                        modifier = Modifier.size(40.dp), // Tamaño del icono
                        contentDescription = "Envíos gratuitos"
                    )
                    Text(
                        text = "Envíos gratuitos a partir de 79€", // Texto del beneficio
                        style = MaterialTheme.typography.bodyMedium, // Estilo del texto
                        color = MaterialTheme.colorScheme.onBackground // Color del texto
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Filled.Autorenew,
                        modifier = Modifier.size(40.dp),
                        contentDescription = "Devolución gratuita"
                    )
                    Text(
                        text = "Devolución gratuita",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            // Segunda fila de beneficios (financiación, entrega rápida)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Filled.CreditCard,
                        modifier = Modifier.size(40.dp),
                        contentDescription = "Financiación"
                    )
                    Text(
                        text = "Servicio de financiación",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Filled.LocalAirport,
                        modifier = Modifier.size(40.dp),
                        contentDescription = "Entrega rápida"
                    )
                    Text(
                        text = "Entrega en máximo 3 días",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }

        // Imagen al final del footer
        Box(
            modifier = Modifier
                .fillMaxWidth() // Ocupa el ancho completo
                .align(Alignment.BottomCenter) // Alineación en la parte inferior
        ) {
            Image(
                painter = painterResource(id = R.drawable.img), // Carga la imagen desde los recursos
                contentDescription = "Footer Image",
                modifier = Modifier
                    .fillMaxWidth() // Ocupa el ancho completo
                    .height(150.dp), // Altura fija
                contentScale = ContentScale.Crop // Escala la imagen para cubrir el área
            )
        }
    }
}
