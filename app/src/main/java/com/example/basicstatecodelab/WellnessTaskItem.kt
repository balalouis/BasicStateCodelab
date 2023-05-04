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
import androidx.compose.runtime.MutableState
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
    taskText: String ,
    checked: MutableState<Boolean> ,
    onClose: () -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = taskText, modifier = Modifier
            .weight(1f)
            .padding(start = 16.dp))

        Checkbox(checked = checked.value, onCheckedChange = onCheckedChange)

        IconButton(onClick = onClose ) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    BasicStateCodelabTheme {
//        WellnessTaskItem(taskText = "This is a task", onClose = {}, onCheckedChange = {})
    }
}

data class WellnessTask(
    val id: Int,
    val label: String,
    var checked: MutableState<Boolean> = mutableStateOf(false)
)
