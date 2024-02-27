package com.example.coco.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coco.R
import com.example.coco.presentation.getStarted.TitleContentText
import com.example.coco.ui.theme.fredoka
import com.example.coco.ui.theme.rosa
import com.example.coco.ui.theme.seed
import com.example.coco.ui.theme.text_desc_color

@Composable
fun PetScreen( paddingValues: PaddingValues ) {
    Box(
        Modifier.fillMaxSize().padding( paddingValues )
    ) {
        ImageBanner()
        BodyPetScreen(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun BodyPetScreen(mod: Modifier) {
    Column(
        modifier = mod
            .fillMaxWidth()
            .clip( RoundedCornerShape(32.dp))
            .background(Color.White)
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 24.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 16.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    TitleContentText(text = R.string.def_name)
                    Spacer(modifier = Modifier.height(8.dp))
                    PetTypeText(text = "Border Collie")
                }
                Icon(
                    painter = painterResource(id = R.drawable.female),
                    contentDescription = "Gender",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(48.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(rosa)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.pet),
                contentDescription = "Pet"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "About Bella",
                fontFamily = fredoka,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PetData(stringResource(id = R.string.date_age), "1y 4m 11d")
            PetData(stringResource(id = R.string.date_weight), "7.5 Kg")
            PetData(stringResource(id = R.string.date_height), "54 cm")
            PetData(stringResource(id = R.string.date_color), "Black")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "My first dog which was gifted by my mother for my 20th birthday.",
            fontFamily = fredoka,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Pet"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Bella's Status",
                fontFamily = fredoka,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        PetStateData(title = "Location")
    }
}

@Composable
fun PetStateData(title: String) {
    // TODO: Implementar esto para Vida, Comida y Sentimiento? 
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Filled.LocationOn, contentDescription = "Location",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(seed)
                .padding(8.dp)
        )
        Text(
            text = title,
            fontFamily = fredoka,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = seed
            ),
            shape = RoundedCornerShape( 10.dp),
            onClick = { }
        ) {
            Text(text = "Check Location",
                fontFamily = fredoka,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
                )
            Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "Arrow Right")
        }
    }
}

@Composable
fun PetData(title: String, desc: String) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
            fontFamily = fredoka,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        )
        Text(
            text = desc,
            fontFamily = fredoka,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = text_desc_color,
            modifier = Modifier.padding(bottom = 8.dp, start = 12.dp, end = 12.dp)
        )
    }
}

@Composable
fun ImageBanner() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp),
        painter = painterResource(id = R.drawable.pet_sample),
        contentDescription = "Pet",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center
    )
}

@Composable
fun PetTypeText(text: String) {
    Text(
        text = text,
        fontFamily = fredoka,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = text_desc_color
    )
}