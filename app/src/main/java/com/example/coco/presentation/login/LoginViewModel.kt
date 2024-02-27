package com.example.coco.presentation.login

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.coco.MainActivity
import com.example.coco.StartActivity

class LoginViewModel(val navController: NavHostController, val context: Context) : ViewModel() {
    fun onLoginButtonClick() {
        val i = Intent( context, MainActivity::class.java )
        context.startActivity( i )
    }
}