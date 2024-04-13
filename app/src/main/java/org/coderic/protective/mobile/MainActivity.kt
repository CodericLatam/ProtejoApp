package org.coderic.protective.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.coderic.protective.mobile.model.Routes
import org.coderic.protective.mobile.presentation.DashBoardScreen
import org.coderic.protective.mobile.presentation.DeviceScreen
import org.coderic.protective.mobile.presentation.LoadingScreen
import org.coderic.protective.mobile.presentation.pet.UpdatePetScreen
import org.coderic.protective.mobile.presentation.components.MyBottomBar
import org.coderic.protective.mobile.presentation.pet.PetScreen
import org.coderic.protective.mobile.presentation.pet.PetViewModel
import org.coderic.protective.mobile.ui.theme.CocoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CocoAppTheme {
                val navController = rememberNavController()
                var showNav by remember { mutableStateOf( true ) }
                val petViewModel = PetViewModel( this@MainActivity, navController )

                Scaffold (
                    modifier = Modifier
                        .fillMaxSize(),
                    contentColor = MaterialTheme.colorScheme.background,
                    bottomBar = {
                        if( showNav ) MyBottomBar( navController )
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MainScreen.route
                    ) {
                        composable( Routes.MainScreen.route ) {
                            showNav = true
                            DashBoardScreen(paddingValues = paddingValues, navController )
                        }
                        composable( Routes.MyPetScreen.route) {
                            showNav = true
                            PetScreen( paddingValues = paddingValues, petViewModel )
                        }
                        composable(Routes.MyUpdatePetScreen.route ) {
                            showNav = true
                            UpdatePetScreen( petViewModel, paddingValues )
                        }
                        composable( Routes.ExploreScreen.route ) {
                            showNav = true
                            LoadingScreen(paddingValues = paddingValues )
                        }
                        composable( Routes.ManageScreen.route ) {
                            showNav = true
                            DeviceScreen( paddingValues )
                        }
                        composable( Routes.MyUpdatePetScreen.route ) {
                            showNav = false
                            UpdatePetScreen( petViewModel, paddingValues )
                        }
                    }
                }
            }
        }
    }
}