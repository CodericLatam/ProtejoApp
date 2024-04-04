package org.coderic.protective.mobile.presentation.pet

import androidx.lifecycle.ViewModel
import org.coderic.protective.mobile.model.datos.Gender
import org.coderic.protective.mobile.model.datos.Pet

class PetViewModel : ViewModel() {
    val myPet = Pet(
        name = "Bella",
        typePet = "Border Collie",
        gender = Gender.MAN,
        age = 11,
        weight = 7.5f,
        height = 54,
        color = "Black",
        description = "My first dog which was gifted by my mother for my 20th birthday."
    )
}