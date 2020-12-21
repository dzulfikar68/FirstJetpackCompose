package id.refactory.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class Part8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.padding(16.dp)) {
                    val openDialog = remember { mutableStateOf(false) }
                    val snackbarVisibleState = remember { mutableStateOf(false) }

                    Button(onClick = { openDialog.value = true }) {
                        if (snackbarVisibleState.value) {
                            Text("Hide Snackbar")
                        } else {
                            Text("Show Snackbar")
                        }
                    }
                    if (snackbarVisibleState.value) {
                        Snackbar(
                            text = { Text(text = "Ini snackbar!") },
                            action = {
                                Button(onClick = {
                                    Toast.makeText(baseContext, "Hello Dunia!", Toast.LENGTH_SHORT).show()
                                }) {
                                    Text("Klik sini")
                                }
                            },
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    AlertDialog(openDialog, snackbarVisibleState)
                }
            }
        }
    }

    @Composable
    fun AlertDialog(alertBoolean: MutableState<Boolean>, snackbarBoolean: MutableState<Boolean>) {
        if (alertBoolean.value) {
            AlertDialog(
                onDismissRequest = { alertBoolean.value = false },
                title = { Text(text = "Alert Dialog") },
                text = { Text("Klik OK untuk menampilkan Snackbar...") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            snackbarBoolean.value = true
                            alertBoolean.value = false
                        }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            snackbarBoolean.value = false
                            alertBoolean.value = false
                        }
                    ) {
                        Text("Hide")
                    }
                },
                backgroundColor = Color.Black,
                contentColor = Color.White
            )
        }
    }

}