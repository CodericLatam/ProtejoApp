package org.coderic.protective.mobile.model

sealed class Routes( val route : String ) {
    // Ruts de Start Activity
    data object InicioSesion: Routes("inicio/inicio_sesion")
    data object GetStarted: Routes("inicio/get_started")
    // Ruts de MainActivity
    data object MainScreen: Routes("main/home")
    data object MyPetScreen: Routes("main/profile")
    data object MyUpdatePetScreen : Routes("main/profile/update")
    data object ExploreScreen: Routes("main/explore")
    data object ManageScreen: Routes("main/manage")

}