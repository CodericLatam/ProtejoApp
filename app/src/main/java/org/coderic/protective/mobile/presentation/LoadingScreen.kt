package org.coderic.protective.mobile.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.coderic.protective.mobile.R
import org.coderic.protective.mobile.ui.theme.fredoka
import org.coderic.protective.mobile.ui.theme.seed

@Composable
fun LoadingScreen(paddingValues: PaddingValues) {
    Column(
        Modifier
            .fillMaxSize()
            .background(seed)
            .padding( paddingValues ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.loading_image),
            contentDescription = "loading",
            modifier = Modifier.size( 320.dp )
        )
        Text(
            text = stringResource(id = R.string.loading),
            fontSize = 32.sp,
            fontFamily = fredoka,
            letterSpacing = 5.sp
        )
    }

}