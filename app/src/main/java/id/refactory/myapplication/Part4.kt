package id.refactory.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class Part4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.padding(16.dp)) {
                    TextField("Edit Text")
                    Spacer(Modifier.preferredHeight(16.dp))
                    DropDown()
                }
            }
        }
    }

    @Composable
    private fun DropDown() {
        val items = listOf("Apple", "Banana", "Cherry", "Duck", "Eagle")
        val showMenu = remember { mutableStateOf( false ) }
        val selectedIndex = remember { mutableStateOf(0) }

        DropdownMenu(
            toggle = {
                Text(items[selectedIndex.value], modifier = Modifier.fillMaxWidth().padding(16.dp))
            },
            expanded = showMenu.value,
            onDismissRequest = { showMenu.value = false },
            toggleModifier = Modifier.fillMaxWidth().background(Color.LightGray).clickable(onClick = { showMenu.value = true }),
            dropdownModifier = Modifier.fillMaxWidth().background(Color(0xFFFFFFFF))
        ) {
            items.forEachIndexed { index, string ->
                DropdownMenuItem(
                    enabled = true,
                    onClick = {
                        selectedIndex.value = index
                        showMenu.value = false
                    }
                ) {
                    Text(text = string)
                }
            }
        }
    }

    @Composable
    private fun TextField(title: String) {
        val text = remember { mutableStateOf(TextFieldValue("-")) }
        OutlinedTextField(
            value = text.value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { text.value = it },
            label = { Text(title) }
        )
    }
}