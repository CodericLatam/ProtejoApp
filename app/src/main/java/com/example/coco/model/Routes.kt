package com.example.coco.model

sealed class Routes( val route : String ) {
    object InicioSesion: Routes("inicio/inicio_sesion")
    object GetStarted: Routes("inicio/get_started")

    object MainScreen: Routes("main/inicio")
    object MyPetScreen: Routes("main/profile")
}