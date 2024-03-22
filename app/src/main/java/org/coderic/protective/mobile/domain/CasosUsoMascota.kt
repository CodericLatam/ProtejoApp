package org.coderic.protective.mobile.domain

import android.content.Context
import org.coderic.protective.mobile.data.Almacenamiento
import org.coderic.protective.mobile.data.MacronutrientPreferences
import org.coderic.protective.mobile.model.datos.Gender
import org.coderic.protective.mobile.model.datos.Pet

class CasosUsoMascota( context: Context ) {
    val almacenamiento : Almacenamiento = MacronutrientPreferences( context )
    fun guardarMascota( pet: Pet ) {
        almacenamiento.savePet( pet )
    }
    fun getMascota( id: Long ) : Pet {
        almacenamiento.getPet( id )
        return Pet(
            name = "Bella",
            typePet = "Border Collie",
            gender = Gender.MAN,
            age = 11,
            weight = 7.5,
            height = 54,
            color = "Black",
            description = "My first dog which was gifted by my mother for my 20th birthday."
        )
    }

}