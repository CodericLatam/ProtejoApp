package org.coderic.protective.mobile.presentation.pet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.coderic.protective.mobile.R
import org.coderic.protective.mobile.model.datos.Gender
import org.coderic.protective.mobile.model.datos.Pet
import org.coderic.protective.mobile.ui.theme.PetCareContentText
import org.coderic.protective.mobile.ui.theme.PetCareNumberField
import org.coderic.protective.mobile.ui.theme.PetCareTextField
import org.coderic.protective.mobile.ui.theme.PetCareTitleText
import org.coderic.protective.mobile.ui.theme.seed

@Composable
fun UpdatePetScreen( petViewModel: PetViewModel, paddingValues: PaddingValues ) {

    var name by rememberSaveable { mutableStateOf("") }
    var selected by rememberSaveable { mutableIntStateOf(1) }

    var age by rememberSaveable { mutableStateOf("") }
    var height by rememberSaveable { mutableStateOf("") }
    var weight by rememberSaveable { mutableStateOf("") }
    var color by rememberSaveable { mutableStateOf("") }
    var type by rememberSaveable { mutableStateOf("") }

    var desc by rememberSaveable { mutableStateOf("") }

    // TODO: Agregar Subida de imagenes.
    var imageRoute by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PetCareTitleText(text = if( petViewModel.myPet == null ) stringResource(id = R.string.formRegistrar ) else stringResource(
            id = R.string.formActualizar
        ), size = 36)
        SectionFormName( text = stringResource(id = R.string.nameForm), name, R.string.nameFormPlaceholder ) {
            name = it
        }
        SectionFormDescription( desc ) {
            desc = it
        }
        SectionFormGender( selected ) {
            selected = it
        }
        SectionFormData( age, height, weight, color, type ) {
            who, data -> when( who ) {
                1 -> age = data
                2 -> height = data
                3 -> weight = data
                4 -> color = data
                5 -> type = data
            }
        }
        SectionFormButton {
            petViewModel.btnAddPet( Pet(
                name = name,
                gender = if( selected == 1 ) Gender.MAN else Gender.FEMALE,
                typePet = type,
                color = color,
                description = desc,
                height = height.toInt(),
                weight = weight.toDouble(),
                age = age.toInt()
            ))
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
@Composable
fun SectionFormGender( selected: Int, onSelected: ( Int ) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation( 8.dp ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = seed
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PetCareTitleText(text = stringResource(id = R.string.genderForm), size = 24 )
            Row( verticalAlignment = Alignment.CenterVertically ) {
                RadioButton(selected = selected == 1, onClick = { onSelected(1) } )
                PetCareContentText(text = stringResource(id = R.string.man), size = 16)
            }
            Row( verticalAlignment = Alignment.CenterVertically ) {
                RadioButton(selected = selected == 2, onClick = { onSelected(2) } )
                PetCareContentText(text = stringResource(id = R.string.female), size = 16)
            }

        }
    }
}
@Composable
fun SectionFormName(text: String, value: String, placeholder: Int, onChange: (String) -> Unit ) {
    Card(
        elevation = CardDefaults.cardElevation( 8.dp ),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PetCareTitleText(text = text, size = 24 )
            Spacer(modifier = Modifier.height(8.dp))
            PetCareTextField(value = value, placeholder = placeholder, imageVector = Icons.Filled.AccountCircle ) {
                onChange( it )
            }
        }
    }
}
@Composable
fun SectionFormData( age: String, weight: String, height: String, color: String, type:String, onChange: (Int, String) -> Unit ) {
    Card(
        elevation = CardDefaults.cardElevation( 8.dp ),
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PetCareTitleText(text = stringResource(id = R.string.titleForm), size = 24 )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                PetCareContentText(text = stringResource(id = R.string.ageForm), size = 16 )
                PetCareNumberField(value = age, imageVector = Icons.Sharp.KeyboardArrowRight ) {
                    onChange(1, it)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                PetCareContentText(text = stringResource(id = R.string.weightForm), size = 16 )
                PetCareNumberField(value = weight, imageVector = Icons.Sharp.KeyboardArrowRight ) {
                    onChange( 2, it )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                PetCareContentText(text = stringResource(id = R.string.heightForm), size = 16 )
                PetCareNumberField(value = height, imageVector = Icons.Sharp.KeyboardArrowRight ) {
                    onChange( 3, it )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                PetCareContentText(text = stringResource(id = R.string.colorForm), size = 16 )
                PetCareTextField(value = color, imageVector = Icons.Sharp.KeyboardArrowRight ) {
                    onChange( 4, it )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                PetCareContentText(text = stringResource(id = R.string.typeForm ), size = 16 )
                PetCareTextField(value = type, imageVector = Icons.Sharp.KeyboardArrowRight ) {
                    onChange( 5, it )
                }
            }
        }
    }
}
@Composable
fun SectionFormDescription( desc: String, onChange: (String) -> Unit) {

    Card(
        elevation = CardDefaults.cardElevation( 8.dp ),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PetCareTitleText(text = stringResource(id = R.string.descriptionForm), size = 24 )
            Spacer(modifier = Modifier.height(8.dp))
            PetCareTextField(value = desc, imageVector = Icons.Filled.Info ) {
                onChange( it )
            }
        }
    }
}
@Composable
fun SectionFormButton( onClick: () -> Unit ) {
    Button(
        modifier = Modifier
            .fillMaxWidth(0.8f),
        onClick = { onClick() },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = seed,
            contentColor = Color.White
        )
    ) {
        PetCareContentText(text = stringResource(id = R.string.btnAddPet), size = 24 )
    }
}