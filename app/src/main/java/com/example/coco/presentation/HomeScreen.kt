package com.example.coco.presentation

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coco.R
import com.example.coco.ui.theme.buttonHome
import com.example.coco.ui.theme.fredoka
import com.example.coco.ui.theme.surfaceHome

@Preview
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(surfaceHome)
            .fillMaxSize()
    ) {
        HomeImage(modifier = Modifier
            .weight(1f)
            .align(Alignment.CenterHorizontally))
        HomeBanner(modifier = Modifier.weight(1f))
    }
}
@Composable
fun HomeImage( modifier : Modifier ) {
    Image(
        modifier = modifier.size(292.dp),
        painter = painterResource(id = R.drawable.ic_launcher),
        contentDescription = "Coco Icon",
        alignment = Alignment.BottomCenter
    )
}
@Composable
fun HomeBanner( modifier : Modifier ) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BoldText(text = stringResource( id = R.string.welcome ) )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            textAlign = TextAlign.Center,
            fontFamily = fredoka,
            fontWeight = FontWeight.Light,
            text = stringResource( id = R.string.description )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonHome
            ),
            onClick = { }
        ) {
            Text(text = stringResource(id = R.string.btnStarted),
                textAlign = TextAlign.Center,
                fontFamily = fredoka,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "ArrowLeft", modifier = Modifier.size(24.dp))
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            BoldText(text = stringResource(id = R.string.haveAccount))

            TextButton(onClick = { }) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontFamily = fredoka,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = buttonHome
                )
            }
        }
    }
}
@Composable
fun BoldText( text: String ) {
    Text(
        text = text,
        fontFamily = fredoka,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
        )
}