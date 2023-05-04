package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    taskText: String = "",
    onClose: () -> Unit,
    checked: Boolean = false,
    onChecked: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = taskText, modifier = Modifier
            .weight(1f)
            .padding(start = 16.dp))

        Checkbox(checked = checked, onCheckedChange = onChecked)

        IconButton(onClick = onClose ) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Composable
fun WellnessTaskItem(taskName: String, modifier: Modifier = Modifier, onClose: () -> Unit) {

    var checkedState by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(
        modifier = modifier,
        taskText = taskName,
        checked = checkedState,
        onClose = onClose,
        onChecked = { newValue -> checkedState = newValue})

}


@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    BasicStateCodelabTheme {
        WellnessTaskItem(taskText = "This is a task", onClose = {}, onChecked = {})
    }
}

data class WellnessTask(val id: Int, val label: String)