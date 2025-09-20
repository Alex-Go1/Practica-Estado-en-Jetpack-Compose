package com.example.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import kotlin.collections.find
import androidx.compose.runtime.toMutableStateList

class WellnessViewModel : ViewModel() {

    // Lista mutable que Compose puede observar
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }
}


