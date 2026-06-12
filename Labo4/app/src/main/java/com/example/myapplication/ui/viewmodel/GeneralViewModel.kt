package com.example.myapplication.ui.viewmodel

import android.R.attr.description
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.local.LabDao
import com.example.myapplication.data.local.entities.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GeneralViewModel(private val dao : LabDao): ViewModel() {

    val tasks = dao.getAllTasks().stateIn(scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            dao.insertTask(Task(title = title, description = description, isCompleted = false, id = 0))
        }
    }


}

