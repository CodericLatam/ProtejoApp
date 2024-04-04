package org.coderic.protective.mobile.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.coderic.protective.mobile.R
import org.coderic.protective.mobile.ui.theme.PetCareContentText
import org.coderic.protective.mobile.ui.theme.PetCareTitleText

@Composable
fun DeviceScreen(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageBanner(id = R.drawable.collar_sample)
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(Color.White)
                .padding(24.dp)
                .weight(1f)
        ) {
            TitleNameDevice()
            Spacer(modifier = Modifier.height(24.dp))
            StatusDevice()
            Spacer(modifier = Modifier.height(24.dp))
            PetStatus()
        }
    }
}

@Composable
fun ImageBanner(@DrawableRes id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "Image",
        modifier = Modifier.size(260.dp),
        contentScale = ContentScale.FillHeight
    )
}

// TODO: Crear objeto Device y mandarlo por parametro o ViewModel
@Composable
fun TitleNameDevice() {
    Card(
    shape = RoundedCornerShape( 32.dp ),
        colors = CardDefaults.cardColors(
        containerColor = Color.White
    ),
        elevation = CardDefaults.cardElevation( 24.dp )) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically ) {
            PetCareTitleText( text = "Fi Smart Collar", size = 28 )
            PetCareContentText(text = "Blocky", size = 16)
        }
    }
}

// TODO: Hacer que la pantalla muestre la bateria del dispositivo.
@Composable
fun StatusDevice() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation( 16.dp )
    ) {
        Row( Modifier.padding(16.dp)) {
            PetCareContentText(text = "Connected", size = 16, modifier = Modifier.weight( 1f ), align = TextAlign.Start )

            Icon(painterResource(id = R.drawable.bateria ), contentDescription = "Pila", tint = Color.Black,
                modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(8.dp))

            PetCareContentText(text = "46 %", size = 16)
        }
    }
}

@Composable
fun PetStatus() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation( 24.dp ),
    ) {
        Row( Modifier.padding( horizontal = 16.dp, vertical = 8.dp )) {
            Icon(
                painterResource(id = R.drawable.sound_dog_icon),
                contentDescription = "Face",
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
            PetCareTitleText("Pet Status", 24 )
        }
        Row(Modifier.padding( horizontal = 16.dp, vertical = 16.dp )) {
            Card {
                Image(
                    painter = painterResource(id = R.drawable.pet_perfil_sample),
                    contentDescription = "Pet",
                    modifier = Modifier
                        .background(Color.Yellow)
                        .size(80.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxHeight()
            ) {
                Status("Health", 88)
                Status("Food", 48)
                Status("Mood", 51)
            }
        }
    }
}

@Composable
fun Status(name: String, value: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        PetCareContentText( name, 12, modifier =  Modifier.padding(end = 16.dp, start = 16.dp ))
        LinearProgressIndicator(progress = (value.toFloat() / 100), modifier = Modifier.weight(1f) )
        PetCareContentText("$value %", 12,  Color.Red, modifier = Modifier.padding(start = 16.dp) )
    }
}