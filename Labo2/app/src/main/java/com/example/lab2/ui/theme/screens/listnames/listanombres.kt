package com.example.lab2.ui.theme.screens.listnames

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListaNombres(
    onBack: () -> Unit
){

    val usuario: MutableState<String> = remember { mutableStateOf("") }

    val lista = remember { mutableStateListOf<String>() }


    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)

    ) {

        IconButton(
            onClick = onBack
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Regresar"
            )
        }

        Spacer(modifier = Modifier.padding(all = 16.dp))

        TextField(
            value = usuario.value,
            onValueChange = {
                usuario.value = it
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)

        )

        Button(
            onClick = {
                lista.add(usuario.value)
                usuario.value = ""
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)

        ) {
            Text(text = "Guardar")
        }

        Spacer(modifier = Modifier.padding(all = 16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Text("Listado de nombres y poscicion \nen la lista")

            Button(
                onClick = {
                    lista.clear()
                }

            ) {
                Text(text = "Limpiar")
            }
        }

        LazyColumn(
            modifier = Modifier.border(
                width = 2.dp,
                color = Color.Blue
            )
        ) {
            itemsIndexed(

                lista.toList()

            ) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item
                    )
                    Text(
                        text = (index + 1).toString()
                    )
                }
            }
        }

    }


}
