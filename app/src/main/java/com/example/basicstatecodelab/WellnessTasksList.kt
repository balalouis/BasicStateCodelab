package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

fun getWellnessTaskList() = List(30){ i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTaskList(modifier: Modifier = Modifier, list: List<WellnessTask>, onCloseTask: (WellnessTask) -> Unit){
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(taskName = task.label, onClose = { onCloseTask(task) })
        }
    }
}
