package com.example.coco.presentation.getStarted

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.coco.R
import com.example.coco.model.Routes

class GetStartedViewModel( val navController: NavHostController ) : ViewModel() {
    private val _screen = MutableLiveData<Int>()
    private val _image  = MutableLiveData<Int>()

    val screen : LiveData<Int> = _screen
    val image : LiveData<Int> = _image

    fun onClick( i: Int ) {
        _screen.value = i;
        if( i == 2 ) _image.value = R.drawable.get_started_2
        if( i == 3 ) _image.value = R.drawable.get_started_3
    }
    fun onLoginBtnClick() {
        navController.navigate( Routes.InicioSesion.route )
    }
}