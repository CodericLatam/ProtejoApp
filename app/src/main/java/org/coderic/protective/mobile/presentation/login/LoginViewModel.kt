package org.coderic.protective.mobile.presentation.login

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import org.coderic.protective.mobile.MainActivity
import org.coderic.protective.mobile.StartActivity

class LoginViewModel(val navController: NavHostController, val context: Context) : ViewModel() {
    fun onLoginButtonClick() {
        val i = Intent( context, MainActivity::class.java )
        context.startActivity( i )
    }
}