package com.example.login.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R

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
                .width(125.dp)
                .padding(end = 10.dp)
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
        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Compra Online", fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        Text(text ="En tu tienda", fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        Text(text ="Lidl Plus", fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        Text(text ="Recetas", fontSize = 15.sp, modifier = Modifier.padding(10.dp))


    }

}


