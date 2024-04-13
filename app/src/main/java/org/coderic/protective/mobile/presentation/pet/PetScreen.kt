package org.coderic.protective.mobile.presentation.pet

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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.coderic.protective.mobile.R
import org.coderic.protective.mobile.model.datos.Pet
import org.coderic.protective.mobile.ui.theme.PetCareContentText
import org.coderic.protective.mobile.ui.theme.PetCareTitleText
import org.coderic.protective.mobile.ui.theme.rosa
import org.coderic.protective.mobile.ui.theme.seed
import org.coderic.protective.mobile.ui.theme.text_desc_color

@Composable
fun PetScreen( paddingValues: PaddingValues, petViewModel: PetViewModel) {
    val arePet by petViewModel.arePet.observeAsState( initial = false )

    petViewModel.getPet()
    Box(
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        if( arePet != false ) {
            ImageBanner()
            ButtonDelete( Modifier.align( Alignment.TopEnd ) ) {
                petViewModel.deletePet( petViewModel.myPet.value!! )
            }
            BodyPetScreen(Modifier.align(Alignment.BottomCenter), petViewModel )
        }
        else {
            NoPetScreen( paddingValues, petViewModel )
        }
    }
}
@Composable
fun ButtonDelete( modifier: Modifier, onClick: () -> Unit ) {
    Button(
        modifier = modifier,
        onClick = { onClick() }
    ) {
        Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete")
    }
}
@Composable
fun NoPetScreen(paddingValues: PaddingValues, petViewModel: PetViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(painter = painterResource(id = R.drawable.sound_dog_icon), contentDescription = "Pet", Modifier.size(80.dp), tint = Color.Black)
        PetCareTitleText(text = stringResource(id = R.string.addPet), 24)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            onClick = { petViewModel.btnToAddPet() },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = seed,
                contentColor = Color.White
            )
        )  {
            Icon( imageVector = Icons.Filled.Add, contentDescription = "Add" )
            PetCareTitleText(text = stringResource(id = R.string.addBtn), 16, Color.White )
        }
    }
}

@Composable
fun BodyPetScreen( modifier: Modifier, petViewModel: PetViewModel ) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(Color.White)
            .padding(start = 32.dp, end = 32.dp, top = 8.dp, bottom = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
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
                    PetCareTitleText( text = petViewModel.myPet.value!!.name, 24 )
                    Spacer(modifier = Modifier.height(8.dp))
                    PetCareContentText (text = petViewModel.myPet.value!!.typePet, 16, text_desc_color )
                }
                Icon(
                    painter = painterResource( id = petViewModel.myPet.value!!.gender.image ),
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
                contentDescription = "Pet",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(8.dp))
            PetCareTitleText(text = "About ${petViewModel.myPet.value!!.name}", size = 20)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PetData(stringResource(id = R.string.date_age), "${petViewModel.myPet.value!!.age.toString()} days" )
            PetData(stringResource(id = R.string.date_weight), "${petViewModel.myPet.value!!.weight.toString()} Kg")
            PetData(stringResource(id = R.string.date_height), "${petViewModel.myPet.value!!.height.toString()} cm" )
            PetData(stringResource(id = R.string.date_color), petViewModel.myPet.value!!.color )
        }
        Spacer(modifier = Modifier.height(16.dp))
        PetCareContentText(text = petViewModel.myPet.value!!.description, size = 16, color = Color.Gray, align = TextAlign.Start )
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Pet",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(8.dp))
            PetCareTitleText(text = "${petViewModel.myPet.value!!.name}'s Status", size = 20)
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
        PetCareTitleText(text = title, size = 16)
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = seed
            ),
            shape = RoundedCornerShape( 10.dp),
            onClick = { }
        ) {
            PetCareContentText(text = "Check Location", size = 14, Color.White )
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
        PetCareTitleText(
            text = title,
            size = 16,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
        PetCareTitleText(
            text = desc,
            size = 14,
            text_desc_color,
            modifier = Modifier
                .padding(bottom = 8.dp, start = 12.dp, end = 12.dp)
                .align(Alignment.CenterHorizontally)
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