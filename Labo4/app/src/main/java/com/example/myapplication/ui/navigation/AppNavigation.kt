package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screens.Greeting
import com.example.myapplication.ui.screens.Home
import com.example.myapplication.ui.viewmodel.GeneralViewModel

@Composable
fun Lab4App() {

    val navController = rememberNavController()
    val viewModel: GeneralViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            Home(

                viewModel = viewModel,
                onNavigateToGreeting = {
                    navController.navigate("Greeting")

                }
            )
        }

        composable("greeting") {
            Greeting(
                viewModel = viewModel,
                onBack = {
                    navController.navigate("home")
                }
            )
        }
    }
}





