package org.coderic.protective.mobile.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import org.coderic.protective.mobile.R
import org.coderic.protective.mobile.model.Routes
import org.coderic.protective.mobile.ui.theme.MyNavBarText
import org.coderic.protective.mobile.ui.theme.navColor
import org.coderic.protective.mobile.ui.theme.selectedIconColor

@Composable
fun MyBottomBar( navController: NavHostController) {
    var screen by remember { mutableStateOf( 1 ) }
    NavigationBar (
        containerColor = navColor
    ) {
        NavigationBarItem(
            selected = screen == 1,
            onClick = {
                screen = 1
                navController.navigate( Routes.MainScreen.route )
            },
            icon = { Icon(Icons.Filled.Home, "Home" ) },
            label = { MyNavBarText( stringResource(id = R.string.home ) ) },
            colors = navBarItemColors()
        )
        NavigationBarItem(
            selected = screen == 3,
            onClick = {
                screen = 3
                navController.navigate( Routes.ExploreScreen.route )
            },
            icon = { Icon(Icons.Filled.LocationOn, "Location") },
            label = { MyNavBarText( stringResource(id = R.string.explore) ) },
            colors = navBarItemColors()
        )
        NavigationBarItem(
            selected = screen == 4,
            onClick = {
                screen = 4
                navController.navigate( Routes.ManageScreen.route )
            },
            icon =  { Icon(painterResource(id = R.drawable.devices_icon), "Manage" ) },
            label = { MyNavBarText( stringResource( id = R.string.manage ) ) },
            colors = navBarItemColors()
        )
        NavigationBarItem(
            selected = screen == 5,
            onClick = {
                screen = 5
                navController.navigate( Routes.MyPetScreen.route )
            },
            icon =  { Icon(painterResource(id = R.drawable.sound_dog_icon), "Dog", tint = Color.White) },
            label = { MyNavBarText( stringResource(id = R.string.profile)) },
            colors = navBarItemColors()
        )
    }
}
@Composable
fun navBarItemColors() : NavigationBarItemColors {
    return NavigationBarItemDefaults.colors(
        selectedIconColor = Color.White,
        unselectedIconColor = Color.White,
        indicatorColor = selectedIconColor
    )
}

