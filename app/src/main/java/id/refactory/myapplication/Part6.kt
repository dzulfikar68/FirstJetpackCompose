package id.refactory.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class Part6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Row(modifier = Modifier.padding(16.dp)) {
                    val checkedState = remember { mutableStateOf(true) }

                    Switch(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it }
                    )
                    if (checkedState.value) {
                        CircularProgressIndicator(
                            modifier = Modifier.padding(16.dp),
                            color = Color.Green
                        )
                    }
                }
            }
        }
    }
}