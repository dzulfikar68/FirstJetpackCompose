package id.refactory.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class Part5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.padding(10.dp)) {
                    CheckBox()
                    RadioButton()
                }
            }
        }
    }

    @Composable
    private fun RadioButton() {
        val radioOptions = listOf("Mobil", "Motor", "Sepeda")
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }

        Column(modifier = Modifier.padding(top = 10.dp)) {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) }
                        )
                        .padding(horizontal = 16.dp)
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }

    @Composable
    private fun CheckBox() {
        val checkedState1 = remember { mutableStateOf(true) }
        val checkedState2 = remember { mutableStateOf(false) }

        Column(modifier = Modifier.padding(top = 10.dp)) {
            Row {
                Checkbox(
                    checked = checkedState1.value,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
                    onCheckedChange = { checkedState1.value = it }
                )
                Text(text = "Checkbox Example with color")
            }
            Row {
                Checkbox(
                    checked = checkedState2.value,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
                    onCheckedChange = { checkedState2.value = it }
                )
                Text(text = "Checkbox Example with color")
            }
        }
    }

}