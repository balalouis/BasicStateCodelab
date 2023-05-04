package com.example.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTaskList().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun removeTasks(item: WellnessTask) {
        _tasks.remove(item)
    }

    private fun getWellnessTaskList() = List(30){ i -> WellnessTask(i, "Task # $i") }
}