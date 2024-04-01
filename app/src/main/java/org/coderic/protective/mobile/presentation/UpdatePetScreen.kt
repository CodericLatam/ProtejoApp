package org.coderic.protective.mobile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.coderic.protective.mobile.R
import org.coderic.protective.mobile.presentation.pet.PetViewModel
import org.coderic.protective.mobile.ui.theme.PetCareContentText
import org.coderic.protective.mobile.ui.theme.PetCareNumberField
import org.coderic.protective.mobile.ui.theme.PetCareTextField
import org.coderic.protective.mobile.ui.theme.PetCareTitleText

@Composable
fun UpdatePetScreen(petViewModel: PetViewModel, paddingValues: PaddingValues) {

    var name by rememberSaveable { mutableStateOf("") }

    var desc by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        SectionFormName( text = stringResource(id = R.string.nameForm), name, R.string.nameFormPlaceholder, Icons.Filled.Info  ) {
            name = it
        }
        SectionFormData()
    }
}
@Composable
fun SectionFormName( text: String, value: String, placeholder: Int, imageVector: ImageVector, onChange: (String) -> Unit ) {
    Card(
        elevation = CardDefaults.cardElevation( 8.dp ),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PetCareTitleText(text = text, size = 24 )
            Spacer(modifier = Modifier.height(8.dp))
            PetCareTextField(value = value, placeholder = placeholder, imageVector = imageVector ) {
                onChange( it )
            }
        }
    }
}
@Composable
fun SectionFormData() {

    var age by rememberSaveable { mutableStateOf("") }
    var height by rememberSaveable { mutableStateOf("") }
    var weight by rememberSaveable { mutableStateOf("") }
    var color by rememberSaveable { mutableStateOf("") }

    Card(
        elevation = CardDefaults.cardElevation( 8.dp ),
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PetCareTitleText(text = stringResource(id = R.string.titleForm), size = 24 )
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                PetCareContentText(text = stringResource(id = R.string.ageForm), size = 16 )
                PetCareNumberField(value = age, imageVector = Icons.Sharp.KeyboardArrowRight ) {
                    age = it
                }
            }
            Row {
                PetCareContentText(text = stringResource(id = R.string.weightForm), size = 16 )
                PetCareNumberField(value = weight, imageVector = Icons.Sharp.KeyboardArrowRight ) {
                    weight = it
                }
            }
            Row {
                PetCareContentText(text = stringResource(id = R.string.weightForm), size = 16 )
                PetCareNumberField(value = height, imageVector = Icons.Sharp.KeyboardArrowRight ) {
                    height = it
                }
            }
            Row {
                PetCareContentText(text = stringResource(id = R.string.weightForm), size = 16 )
                PetCareNumberField(value = color, imageVector = Icons.Sharp.KeyboardArrowRight ) {
                    color = it
                }
            }
        }
    }
}