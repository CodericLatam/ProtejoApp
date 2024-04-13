package org.coderic.protective.mobile.presentation.pet

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import org.coderic.protective.mobile.domain.CasosUsoMascota
import org.coderic.protective.mobile.model.Routes
import org.coderic.protective.mobile.model.datos.Pet

class PetViewModel( context: Context, val navController: NavHostController ) : ViewModel() {
    private val casosUsoMascota = CasosUsoMascota( context )

    private val _myPet = MutableLiveData<Pet?>( casosUsoMascota.getMascota() )
    private val _arePet = MutableLiveData<Boolean>()

    val myPet = _myPet
    val arePet = _arePet
    fun btnToAddPet() {
        navController.navigate( Routes.MyUpdatePetScreen.route )
    }
    fun btnAddPet( pet: Pet ) {
        casosUsoMascota.guardarMascota( pet )

        _myPet.value = pet
        arePet.value = true

        navController.navigate( Routes.MyPetScreen.route )
    }
    fun getPet() {
        _myPet.value = casosUsoMascota.getMascota()
        if( _myPet.value == null ) {
            _arePet.value = false
        } else {
            _arePet.value = true
        }
    }
    fun deletePet( pet: Pet ) {
        _arePet.value = false
        _myPet.value = null
        casosUsoMascota.deleteMascota( pet = pet )
    }
}