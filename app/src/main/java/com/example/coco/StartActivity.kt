package com.example.coco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coco.model.Routes
import com.example.coco.presentation.getStarted.GetStartedScreen
import com.example.coco.presentation.getStarted.GetStartedViewModel
import com.example.coco.presentation.login.LoginScreen
import com.example.coco.presentation.login.LoginViewModel
import com.example.coco.ui.theme.CocoAppTheme

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CocoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface (
                    modifier = Modifier
                        .fillMaxSize(),
                    contentColor = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.GetStarted.route
                    ) {
                        composable( Routes.InicioSesion.route ) {
                            val loginViewModel = LoginViewModel( navController, this@StartActivity )
                            LoginScreen( loginViewModel )
                        }
                        composable( Routes.GetStarted.route ) {
                            val getStartedViewModel = GetStartedViewModel( navController )
                            GetStartedScreen( getStartedViewModel = getStartedViewModel )
                        }
                    }
                }
            }
        }
    }
}