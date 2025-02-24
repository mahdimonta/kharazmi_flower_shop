package com.example.composeapp.mainPage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Main()
        }
    }

    @Composable
    fun Main() {
        val navController = rememberNavController()

        val systemUiController = rememberSystemUiController()

        LaunchedEffect(Unit) {
            systemUiController.setStatusBarColor(Color(0xFF18AF7C)) // استاتوس بار قرمز میشه
        }


        Scaffold(
            modifier = Modifier.systemBarsPadding(),
            bottomBar = { BottomNavigation(navController) }
        ) {

            NavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                startDestination = "Home",

            ) {
                composable("Profile") { ProfileScreen() }
                composable("Shop") { ShopScreen() }
                composable("Home") { HomeScreen() }
                composable("Category") { CategoryScreen() }
                composable("Discount") { DiscountScreen() }
            }
        }
    }


    @Preview(
        showBackground = true,
        showSystemUi = true,
        device = Devices.PIXEL_7
    )
    @Composable
    fun GreetingPreview() {

        Main()
    }
}





