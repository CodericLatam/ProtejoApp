package com.example.coco.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.coco.R
import com.example.coco.ui.theme.buttonHome
import com.example.coco.ui.theme.fredoka
import com.example.coco.ui.theme.navColor
import com.example.coco.ui.theme.rosa
import com.example.coco.ui.theme.seed
import com.example.coco.ui.theme.selectedIconColor

@Composable
fun BottomBar() {
    NavigationBar(
        containerColor = navColor
    ) {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Filled.Home, "Home" ) },
            label = { MyTextNavBar(R.string.home) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = selectedIconColor
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(painter = painterResource(id = R.drawable.explore_icon), "Discover") },
            label = { MyTextNavBar(R.string.discover) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = selectedIconColor
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Filled.LocationOn, "Location") },
            label = { MyTextNavBar(R.string.explore) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = selectedIconColor
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(painterResource(id = R.drawable.devices_icon), "Manage" ) },
            label = { MyTextNavBar(R.string.manage) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = selectedIconColor
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(painterResource(id = R.drawable.sound_dog_icon), "Dog", tint = Color.White) },
            label = { MyTextNavBar(R.string.profile) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = selectedIconColor
            )
        )
    }
}

@Composable
fun MyTextNavBar(txt: Int) {
    Text(
        text = stringResource(id = txt),
        fontFamily = fredoka,
        fontWeight = FontWeight.Medium,
        color = Color.White
    )
}