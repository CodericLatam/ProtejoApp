package org.coderic.protective.mobile.model.datos

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.stringResource
import org.coderic.protective.mobile.R

/** Pet
 * @author José Ricardo
 * @param name name of the pet.
 * @param gender gender of the pet
 * @param age age of the pet, auto-calculated
 * @param weight
 * @param height
 * @param color color of the pet
 * @param description a little description of the pet
 * @param image route to image of the pet
 * */
data class Pet(
    val name: String = "",
    val gender: Gender = Gender.FEMALE,
    val typePet: String = "",
    var age : Int = 0,
    var weight: Float = 0f,
    var height: Int = 0,
    val color: String = "",
    var description: String = "",
    var image: String = ""
)
/** Gender.
 * @author José Ricardo
 * @param type Show if the pet is man or female.
 * @param image Show icon of the gender
 * */
enum class Gender( val type: Int, @DrawableRes val image: Int ) {
    MAN( 0,  R.drawable.male ),
    FEMALE( 1, R.drawable.female );
}
