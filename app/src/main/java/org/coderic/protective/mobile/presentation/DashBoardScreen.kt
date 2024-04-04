package org.coderic.protective.mobile.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.coderic.protective.mobile.R
import org.coderic.protective.mobile.model.Routes
import org.coderic.protective.mobile.ui.theme.PetCareTitleText
import org.coderic.protective.mobile.ui.theme.fredoka

@Composable
fun DashBoardScreen(paddingValues: PaddingValues, navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Transparent)
        ) {
            ShowMyPets()

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ){
                Card(
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 8.dp
                    )
                ) {

                    Row(
                        Modifier.padding(8.dp)
                    ) {
                        Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "Location")
                        Text(text = "Pet Location")
                    }
                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = { navController.navigate( Routes.ExploreScreen.route )}) {
                        Text(text = "Track Pets")
                        Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "KeyBoard")
                    }
                }
                Card(
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 8.dp
                    )
                ) {
                    Row(
                        Modifier.padding(8.dp)
                    ) {
                        Icon(painterResource(id = R.drawable.sound_dog_icon), contentDescription = "Status Dog")
                        Text(text = "Pet Status")
                    }
                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = { navController.navigate( Routes.MyPetScreen.route ) } ) {
                        Text(text = "Check Pets")
                        Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "KeyBoard")
                    }
                }
            }
        }
    }
}
@Composable
fun ShowMyPets() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Row(
            modifier = Modifier.padding( 8.dp )
        ) {
            Icon(painter = painterResource(id = R.drawable.pet), contentDescription = "Pet")
            PetCareTitleText(text = "My Pets", 24)
        }
        Row ( horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp) ){
            PetCard(img = R.drawable.pet_perfil_sample, text = "Bella", color = Color.Yellow)
            PetCard(img = R.drawable.my_pet_sample1, text = "Roudy", color = Color.Blue)
            PetCard(img = R.drawable.my_pet_sample2, text = "Furry", color = Color.Red )
        }
    }
}
@Composable 
fun PetCard( modifier: Modifier = Modifier, @DrawableRes img: Int, text: String, color: Color ) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Image(
            painter = painterResource(id = img),
            contentDescription = "Pet Sample",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(96.dp)
                .background(color)
        )
        Text(
            text = text,
            fontFamily = fredoka,
            fontWeight = FontWeight.Light,
            modifier = Modifier.align( Alignment.CenterHorizontally )
        )
    }
}