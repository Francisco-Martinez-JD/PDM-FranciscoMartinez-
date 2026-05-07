package com.example.lab2.ui.theme.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment

@Composable
fun Home(
    onNavigateToListaNombres: () -> Unit,
    onNavigateToSensorProximidad: () -> Unit
){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Button(
            onClick = {
                onNavigateToListaNombres()
            }
        ) {
            Text("Lista de nombres")
        }

        Button(
            onClick = {
                onNavigateToSensorProximidad()
            }
        ) {
            Text ("Prueba de sensores")
        }
    }
}
