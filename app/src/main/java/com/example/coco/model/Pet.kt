package com.example.coco.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.stringResource
import com.example.coco.R

data class Pet(
    val name: String = "",
    val gender: Gender = Gender.MAN,
    val typePet: String = "",
    var age : Int = 0,
    var weight: Float = 0f,
    var height: Int = 0,
    val color: String = "",
    var description: String = "",
    var image: String = ""
)
enum class Gender( @DrawableRes type: Int ) {
    MAN( R.drawable.male ),
    FEMALE(R.drawable.female )
}
