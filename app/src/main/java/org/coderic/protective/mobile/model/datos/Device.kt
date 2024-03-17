package org.coderic.protective.mobile.model.datos

/** Device.
 * @author José Ricardo
 * @param name Shows the name of the device.
 * @param status Shows if the device is conected.
 * @param battery Shows the device battery state.
 * */
data class Device(
    val name: String,
    var status: Boolean = false,
    var battery: Int = 0
)