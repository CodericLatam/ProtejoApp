package com.example.coco

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
import com.example.coco.model.Routes
import com.example.coco.presentation.DeviceScreen
import com.example.coco.presentation.PetScreen
import com.example.coco.presentation.PetViewModel
import com.example.coco.presentation.components.BottomBar
import com.example.coco.ui.theme.CocoAppTheme

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
                    bottomBar = { BottomBar( navController ) }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MainScreen.route
                    ) {
                        composable( Routes.MainScreen.route ) {
                            // TODO: Finish the Main Screen
                        }
                        composable( Routes.MyPetScreen.route) {
                            PetScreen( paddingValues = paddingValues, PetViewModel() )
                        }
                        composable( Routes.ExploreScreen.route ) {
                            // TODO: Finish the explore Screen
                        }
                        composable( Routes.DiscoverScreen.route ) {
                            // TODO: Finish the discover Screen
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