package org.coderic.protective.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.coderic.protective.mobile.model.Routes
import org.coderic.protective.mobile.presentation.DashBoardScreen
import org.coderic.protective.mobile.presentation.DeviceScreen
import org.coderic.protective.mobile.presentation.LoadingScreen
import org.coderic.protective.mobile.presentation.pet.PetScreen
import org.coderic.protective.mobile.presentation.pet.PetViewModel
import org.coderic.protective.mobile.presentation.components.BottomBar
import org.coderic.protective.mobile.ui.theme.CocoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CocoAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Scaffold (
                    modifier = Modifier
                        .fillMaxSize(),
                    contentColor = MaterialTheme.colorScheme.background,
                    bottomBar = {
                        BottomBar( navController )
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MainScreen.route
                    ) {
                        composable( Routes.MainScreen.route ) {
                            DashBoardScreen(paddingValues = paddingValues, navController )
                        }
                        composable( Routes.MyPetScreen.route) {
                            PetScreen( paddingValues = paddingValues, PetViewModel() )
                        }
                        composable( Routes.ExploreScreen.route ) {
                            LoadingScreen(paddingValues = paddingValues )
                        }
                        composable( Routes.ManageScreen.route ) {
                            DeviceScreen( paddingValues )
                        }
                    }
                }
            }
        }
    }
}