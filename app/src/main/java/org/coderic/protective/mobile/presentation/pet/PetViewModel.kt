package org.coderic.protective.mobile.presentation.pet

import android.content.Context
import androidx.lifecycle.ViewModel
import org.coderic.protective.mobile.domain.CasosUsoMascota
import org.coderic.protective.mobile.model.datos.Gender
import org.coderic.protective.mobile.model.datos.Pet

class PetViewModel( context: Context) : ViewModel() {
    val casosUsoMascota = CasosUsoMascota( context )
    val myPet = casosUsoMascota.getMascota( 1231 )
}