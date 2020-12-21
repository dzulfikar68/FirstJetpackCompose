package id.refactory.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class Part7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.padding(16.dp)) {
                    val sliderPosition = remember { mutableStateOf(0f) }

                    Text(text = sliderPosition.value.toString())
                    Slider(
                        value = sliderPosition.value,
                        onValueChange = { sliderPosition.value = it }
                    )
                    if (sliderPosition.value > 0.5f) {
                        LinearProgressIndicator(
                            modifier = Modifier.padding(16.dp).fillMaxWidth(),
                            color = Color.Red
                        )
                    }
                }
            }
        }
    }
}