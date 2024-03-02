package com.example.coco.presentation

import androidx.lifecycle.ViewModel
import com.example.coco.model.datos.Gender
import com.example.coco.model.datos.Pet

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