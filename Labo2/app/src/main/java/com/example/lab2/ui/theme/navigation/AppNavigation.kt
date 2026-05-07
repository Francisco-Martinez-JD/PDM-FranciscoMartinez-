package com.example.lab2.ui.theme.navigation

import android.R.attr.type
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab2.ui.theme.screens.home.Home
import com.example.lab2.ui.theme.screens.listnames.ListaNombres
import com.example.lab2.ui.theme.screens.sensor.LightSensor

@Composable
fun LabosApp(){
    val navController = rememberNavController()
    //val inventoryViewModel: InventoryViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home_view"){
        composable("home_view"){
            Home(
                onNavigateToListaNombres = {
                    navController.navigate("lista_nombres")
                },
                onNavigateToSensorProximidad = {
                    navController.navigate("sensor_proximidad")
                }
            )
        }

        composable("lista_nombres"){
            ListaNombres(
                onBack = {
                    navController.navigate("home_view")
                }
            )
        }

        composable("sensor_proximidad"){
            LightSensor(
                onBack = {
                    navController.navigate("home_view")
                }
            )
        }

    }
}