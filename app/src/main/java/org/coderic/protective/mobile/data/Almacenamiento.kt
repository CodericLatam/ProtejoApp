package org.coderic.protective.mobile.data

import org.coderic.protective.mobile.model.datos.Device
import org.coderic.protective.mobile.model.datos.Pet

interface Almacenamiento {
    fun savePet( pet: Pet )
    fun saveDevice( device: Device )
    fun getPet( id: Long ) : Pet?
    fun getDevice() : Device
}