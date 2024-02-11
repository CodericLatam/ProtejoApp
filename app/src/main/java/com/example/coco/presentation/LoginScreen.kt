package com.example.coco.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coco.R
import com.example.coco.ui.theme.buttonHome

@Composable
fun LoginScreen() {
    Box {
        Footer( Modifier.align( Alignment.BottomCenter ))

        Image(
            modifier = Modifier.align( Alignment.BottomCenter ).fillMaxWidth(),
            painter = painterResource(id = R.drawable.login_background),
            alpha = 0.5f,
            contentDescription = "background",
            contentScale = ContentScale.FillHeight,
        )


        Body(mod = Modifier.align( Alignment.Center ))
    }
}
@Composable
fun Body( mod: Modifier ) {
    Column(
        modifier = mod
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher), contentDescription = "Coco Icon")

        OutlinedTextField(value = "Email Address", onValueChange = { } )
        OutlinedTextField(value = "Password", onValueChange = {} )

        Text(text = "Forget Password?")

    }
}
@Composable
fun Footer( mod: Modifier = Modifier ) {
    Text(
        modifier = mod
            .fillMaxWidth()
            .background(buttonHome)
            .padding(top = 40.dp, bottom = 16.dp),
        text = "© All Rights Reserverd to Pixel Posse - 2022",
        textAlign = TextAlign.Center,
        fontSize = 10.sp,
    )
}