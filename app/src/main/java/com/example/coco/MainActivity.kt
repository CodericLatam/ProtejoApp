package com.example.coco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.coco.presentation.PetScreen
import com.example.coco.presentation.components.BottomBar
import com.example.coco.ui.theme.CocoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CocoAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold (
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background,
                    bottomBar = { BottomBar() }
                ) { paddingValues ->
                    // val getStartedViewModel = GetStartedViewModel()
                    // GetStartedScreen( getStartedViewModel )
                    PetScreen( paddingValues )
                }
            }
        }
    }
}