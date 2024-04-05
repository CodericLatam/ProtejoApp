package org.coderic.protective.mobile.presentation.pet

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import org.coderic.protective.mobile.domain.CasosUsoMascota
import org.coderic.protective.mobile.model.Routes
import org.coderic.protective.mobile.model.datos.Pet

class PetViewModel( val context: Context, val navController: NavHostController ) : ViewModel() {
    val casosUsoMascota = CasosUsoMascota( context )
    var _myPet = casosUsoMascota.getMascota()
    val myPet = _myPet

    fun btnToAddPet() {
        navController.navigate( Routes.MyUpdatePetScreen.route )
    }
    fun btnAddPet( pet: Pet ) {
        casosUsoMascota.guardarMascota( pet )
        _myPet = pet
        Toast.makeText( context, "Mascota Guardada", Toast.LENGTH_LONG ).show()
        navController.navigate( Routes.MyPetScreen.route )
    }
    fun showname() {
        Toast.makeText(context, myPet!!.name, Toast.LENGTH_SHORT).show()
    }
}