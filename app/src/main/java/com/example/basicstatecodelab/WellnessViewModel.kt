package com.example.basicstatecodelab

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTaskList().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun removeTasks(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskCheckedState(task: WellnessTask, checked: Boolean) {
        _tasks.find{ it.id == task.id}.let {
            it?.checked?.value = checked
        }
    }

    private fun getWellnessTaskList() = List(30){ i -> WellnessTask(i, "Task # $i") }
}