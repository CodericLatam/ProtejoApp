package com.example.coco.model

sealed class Routes( val route : String ) {
    // Rutas de Start Activity
    object InicioSesion: Routes("inicio/inicio_sesion")
    object GetStarted: Routes("inicio/get_started")
    // Rutas de MainActivity
    object MainScreen: Routes("main/home")
    object MyPetScreen: Routes("main/profile")
    object ExploreScreen: Routes("main/explore")
    object ManageScreen: Routes("main/manage")
}