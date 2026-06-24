package com.example.labo6.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labo6.data.model.Meal
import com.example.labo6.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {

    var meals by mutableStateOf<List<Meal>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadUsers() {

        viewModelScope.launch {

            isLoading = true

            try {

                meals = RetrofitInstance
                    .api
                    .getMeal()

            } catch (e: Exception) {

                e.printStackTrace()

            } finally {

                isLoading = false
            }
        }
    }
}