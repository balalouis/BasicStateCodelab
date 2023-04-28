package com.example.basicstatecodelab

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessTaskItem(modifier: Modifier = Modifier, taskText: String, onClose : () ->Unit) {
    Log.d("-----> ","WellnessTaskItem")
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = taskText, modifier = Modifier.padding(start = 16.dp))
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close,contentDescription = "Close")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    BasicStateCodelabTheme {
        WellnessTaskItem(taskText = "This is a task", onClose = {})
    }
}