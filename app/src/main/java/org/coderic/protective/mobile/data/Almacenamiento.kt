package org.coderic.protective.mobile.data

import org.coderic.protective.mobile.model.datos.Device
import org.coderic.protective.mobile.model.datos.Pet

interface Almacenamiento {
    fun savePet( pet: Pet )
    fun getPet() : Pet?
    fun saveDevice( device: Device )
    fun getDevice() : Device
}