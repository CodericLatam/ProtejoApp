package org.coderic.protective.mobile.presentation.login

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.coderic.protective.mobile.R
import org.coderic.protective.mobile.model.Routes
import org.coderic.protective.mobile.ui.theme.buttonHome
import org.coderic.protective.mobile.ui.theme.fredoka

@Composable
fun LoginScreen( loginViewModel: LoginViewModel ) {
    Box {
        Footer(Modifier.align(Alignment.BottomCenter))

        Image(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.login_background),
            alpha = 0.2f,
            contentDescription = "background",
            contentScale = ContentScale.FillHeight,
        )


        Body(mod = Modifier.align(Alignment.Center), loginViewModel )
    }
}

@Composable
fun Body( mod: Modifier, loginViewModel: LoginViewModel ) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = mod.padding( 32.dp )
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(200.dp),
            painter = painterResource(id = R.drawable.ic_launcher),
            contentDescription = "Coco Icon"
        )

        MyTextField(value = email, placeholder = R.string.placeholderEmail, Icons.Filled.Email, onValueChange = {
            email = it
        })
        Spacer(modifier = Modifier.height(16.dp))
        MyTextField(value = password, placeholder = R.string.placeholderPass, imageVector = Icons.Filled.Lock, onValueChange = {
            password = it
        })
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(
            modifier = Modifier.align( Alignment.End ),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = stringResource(id = R.string.forget),
                fontFamily = fredoka,
                fontWeight = FontWeight.Medium,
                color = buttonHome,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(Alignment.CenterHorizontally),
            onClick = { loginViewModel.onLoginButtonClick() },
            shape = RoundedCornerShape(10.dp ),
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonHome
            )
        ) {

            Text(
                text = stringResource(id = R.string.LOGIN),
                fontFamily = fredoka,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp
            )
        }

        // Divider
        Spacer(modifier = Modifier.height(16.dp))
        MyDivider()
        Spacer(modifier = Modifier.height(16.dp))

        Column {
            ButtonLogWith(
                text = stringResource(id = R.string.loginGoogle),
                drawable = R.drawable.ic_google
            )
            Spacer(modifier = Modifier.height(6.dp))
            ButtonLogWith(
                text = stringResource(id = R.string.loginFacebook),
                drawable = R.drawable.ic_facebook
            )
            Spacer(modifier = Modifier.height(6.dp))
            ButtonLogWith(
                text = stringResource(id = R.string.loginApple),
                drawable = R.drawable.ic_apple
            )
        }
    }
}
@Composable
fun MyDivider() {
    Row( verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .padding(end = 8.dp)
                .weight(1f))
        Text(text = stringResource(id = R.string.orConnect), color = Color.Gray, fontFamily = fredoka, fontWeight = FontWeight.Medium)
        Divider(
            Modifier
                .padding(start = 8.dp)
                .weight(1f))
    }
}
@Composable
fun MyTextField(value: String, placeholder: Int, imageVector: ImageVector, onValueChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp)),
        value = value,
        onValueChange = { onValueChange(it) },
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = "Email")
        },
        placeholder = {
            Text(text = stringResource(id = placeholder), fontFamily = fredoka, fontWeight = FontWeight.Medium)
                      },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedPlaceholderColor = Color.Gray,
            unfocusedLeadingIconColor = Color.Gray
        )
    )
}

@Composable
fun ButtonLogWith(text: String, @DrawableRes drawable: Int) {
    Button(
        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonHome
        )
    )
    {
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = drawable),
            contentDescription = text,
            modifier = Modifier.size(24.dp)
        )
        Text(text = text, modifier = Modifier.weight(1f).padding(start = 16.dp),
            fontFamily = fredoka,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            fontSize = 20.sp)
    }
}

@Composable
fun Footer(mod: Modifier = Modifier) {
    Text(
        modifier = mod
            .fillMaxWidth()
            .background(buttonHome)
            .padding(top = 40.dp, bottom = 16.dp),
        text = stringResource(id = R.string.footerText),
        textAlign = TextAlign.Center,
        fontSize = 10.sp,
    )
}