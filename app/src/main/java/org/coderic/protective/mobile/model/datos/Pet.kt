package org.coderic.protective.mobile.model.datos

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.stringResource
import org.coderic.protective.mobile.R


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
enum class Gender( val type: Int, @DrawableRes val image: Int ) {
    MAN( 0,  R.drawable.male ),
    FEMALE( 1, R.drawable.female );
}
