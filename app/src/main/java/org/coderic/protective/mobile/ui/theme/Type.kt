package org.coderic.protective.mobile.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.coderic.protective.mobile.R

val fredoka = FontFamily(
    Font( R.font.fredoka_regular, FontWeight.Normal ),
    Font( R.font.fredoka_light, FontWeight.Light ),
    Font( R.font.fredoka_semi_bold, FontWeight.SemiBold ),
    Font( R.font.fredoka_bold, FontWeight.Bold ),
    Font( R.font.fredoka_medium, FontWeight.Medium )
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fredoka,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp
    )
)
@Composable
fun MyNavBarText( text : String ) {
    Text(
        text = text,
        fontFamily = fredoka,
        fontWeight = FontWeight.Medium,
        color = Color.White
    )
}
@Composable
fun PetCareTitleText( text: String, size: Int, modifier: Modifier = Modifier ) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = size.sp,
        modifier = modifier,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium
    )
}
@Composable
fun PetCareTitleText( text: String, size: Int, color: Color, modifier: Modifier = Modifier, align: TextAlign = TextAlign.Center ) {
    Text(
        text = text,
        color = color,
        fontSize = size.sp,
        modifier = modifier,
        textAlign = align,
        style = MaterialTheme.typography.bodyMedium
    )
}
@Composable
fun PetCareContentText( text: String, size: Int, modifier: Modifier = Modifier, align: TextAlign = TextAlign.Center ) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = size.sp,
        modifier = modifier,
        textAlign = align,
        style = MaterialTheme.typography.labelSmall
    )
}
@Composable
fun PetCareContentText( text: String, size: Int, color: Color, modifier: Modifier = Modifier, align: TextAlign = TextAlign.Center ) {
    Text(
        text = text,
        color = color,
        fontSize = size.sp,
        modifier = modifier,
        textAlign = align,
        style = MaterialTheme.typography.labelSmall
    )
}
@Composable
fun PetCareTextField(value: String, placeholder: Int, imageVector: ImageVector, onValueChange: (String) -> Unit ) {
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
            PetCareContentText( text = stringResource(id = placeholder), 16, color = Color.Gray )
        },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedPlaceholderColor = Color.Gray,
            unfocusedLeadingIconColor = Color.Gray
        )
    )
}