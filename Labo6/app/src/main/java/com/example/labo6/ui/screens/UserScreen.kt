package com.example.labo6.ui.screens

import android.R.attr.contentDescription
import android.app.ProgressDialog.show
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.labo6.viewmodel.MealViewModel

@Composable
fun UserScreen(
    viewModel: MealViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    when {

        viewModel.isLoading -> {

            CircularProgressIndicator()
        }

        else -> {

            LazyColumn {

                items(viewModel.meals) { meal ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {

                        Row(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(text = meal.strMeal)
                                Text(text = meal.strCategory)
                                Text(text = meal.strArea)
                            }

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                AsyncImage(
                                    model = meal.strMealThumb?.length,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize(),
                                    placeholder = ColorPainter(Color.DarkGray)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}