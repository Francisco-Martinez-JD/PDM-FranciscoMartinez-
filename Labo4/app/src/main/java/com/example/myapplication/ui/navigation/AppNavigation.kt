package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.ui.screens.Greeting
import com.example.myapplication.ui.screens.Home
import com.example.myapplication.ui.viewmodel.GeneralViewModel


@Composable
fun Lab4App() {


    val navController = rememberNavController()

    val applicationContext = LocalContext.current.applicationContext
    val db = AppDatabase.getDatabase(applicationContext)
    val viewModel: GeneralViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return GeneralViewModel(db.LabDao()) as T
            }
        }
    )
    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            Home(

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





