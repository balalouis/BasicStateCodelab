package com.example.basicstatecodelab
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun WaterStatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {

        if (count > 0) {
            Text(
                text = "You've had $count glasses of water."
            )
        }
        Button(onClick = onIncrement, modifier = Modifier.padding(8.dp), enabled = count < 10) {
            Text(text = "Add One")
        }
    }
}

@Composable
fun WaterStatefullCounter(modifier: Modifier = Modifier) {
    var count: Int  by remember { mutableStateOf(0) }
    WaterStatelessCounter(count = count, onIncrement = { count++ })
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Log.d("-----> ","Above Column")
    var count by rememberSaveable { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Log.d("-----> ","Above if count")
        if (count > 0) {
            Log.d("-----> ","Inside if count")
            var showTask by remember { mutableStateOf(true) }
            if(showTask) {
                Log.d("-----> ","Inside if show task")
                WellnessTaskItem(modifier = Modifier, taskText = "This is a task", onClose = { showTask = false})
            }
            Log.d("-----> ","outside if show task")
            Text(
                text = "You've had $count glasses of water."
            )
        }
        Log.d("-----> ","outside if count")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Log.d("-----> ","Row")
            Button(onClick = { count++ }, enabled = count < 10) {
                Text(text = "Add")
            }
            Button(onClick = { count = 0 }, Modifier.padding(start = 16.dp)) {
                Text(text = "Clear water count")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    BasicStateCodelabTheme {
        WaterCounter()
    }
}