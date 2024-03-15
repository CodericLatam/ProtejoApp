package org.coderic.protective.mobile.model.datos

/** GeoPunto.
 * @param latitud
 * @param longitud
 * */
data class GeoPunto( var latitud : Long, var longitud: Long ) {
    val SIN_POSICION = GeoPunto( 0, 0 )
}
