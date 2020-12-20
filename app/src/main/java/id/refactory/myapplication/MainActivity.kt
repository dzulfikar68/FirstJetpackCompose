package id.refactory.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                NewsStory()
                Toast.makeText(baseContext, "Author: $", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    @Composable
    private fun NewsStory() {
        val image = vectorResource(id = R.drawable.ic_launcher_background)
        ScrollableColumn {
            Column (
                modifier = Modifier.padding(16.dp).align(alignment = Alignment.CenterHorizontally)
            ) {
                val imageModifier = Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))
                Image(image, modifier = imageModifier,
                    contentScale = ContentScale.Crop)

                DropdownDemo()

                Spacer(Modifier.preferredHeight(16.dp))
                Text("A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis)
                Text("Davenport, California")
                Text("Desember 2018")

                IconButton(onClick = { onBackPressed() }) {
                    Image(imageVector = vectorResource(id = R.drawable.ic_android_black_24dp))
                }

                Button(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .preferredHeight(36.dp),
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        onBackPressed()
                    }
                ) {
                    Text(
                        stringResource(id = R.string.app_name),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                LazyRow {
                    items(items = (1..10).toList(), itemContent = {
//                        Text(text = "Item $it")
                        ViewItem(itemText = "Item $it")
                    })
                }

//            val ll = listOf("X","Y","Z")
//            MyLazyColumn(listItems = ll)

                val text = remember { mutableStateOf(TextFieldValue("Text")) }
                OutlinedTextField(value = text.value,
                    onValueChange = { text.value = it },
                    label = { Text("Test") })

                SimpleRadioButtonComponent()

                ColoredCheckboxComponent()
                SimpleSnackbarComponent()

                val cpVisibleState = remember { mutableStateOf(true) }
                if (cpVisibleState.value) {
                    CircularProgressIndicator(
                        modifier = Modifier.padding(16.dp),
                        color = Color.Green
                    )
                }

                val items = listOf("A", "B", "C", "D", "E", "F")
                val blogList = remember { mutableStateOf(items) }
                for (blog in blogList.value) {
                    LinearProgressIndicator(
                        modifier = Modifier.padding(16.dp).fillMaxWidth().clickable(onClick = {
                            cpVisibleState.value = false
                        }),
                        color = Color.Red
                    )
                }

                SwitchDemo()

                BorderedCardComponent()

                AlertDialogComponent()

                MySliderDemo()
            }
        }

    }

    @Composable
    fun AlertDialogComponent() {
        val openDialog = remember { mutableStateOf(true) }
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false },
                title = { Text(text = "Alert Dialog") },
                text = { Text("Hello! I am an Alert Dialog") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                            /* Do some other action */
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                            /* Do some other action */
                        }
                    ) {
                        Text("Dismiss")
                    }
                },
                backgroundColor = Color.Black,
                contentColor = Color.White
            )
        }
    }

    @Composable
    fun BorderedCardComponent() {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color(0xFFFFA867.toInt()),
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green)),
            modifier = Modifier.padding(16.dp).fillMaxWidth().clickable(onClick = {
                Toast.makeText(baseContext, "Thanks for clicking!", Toast.LENGTH_SHORT).show()
            })
        ) {
            Text(
                text = "Bordered Card",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp,
//                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    @Composable
    fun MySliderDemo() {
        val sliderPosition = remember { mutableStateOf(0f) }
        Text(text = sliderPosition.value.toString())
        Slider(value = sliderPosition.value, onValueChange = { sliderPosition.value = it })
    }

    @Composable
    fun ModalDrawerLayoutSample() {
        val drawerState = rememberDrawerState(DrawerValue.Closed)

        ModalDrawerLayout(
            drawerState = drawerState,
            drawerContent = {
                Column {
                    Text("Text in Drawer")
                    Button(onClick = { drawerState.close() }) {
                        Text("Close Drawer")
                    }
                }
            },
            bodyContent = {
                Column {
                    Text("Text in Bodycontext")
                    Button(onClick = { drawerState.open() }) {
                        Text("Click to open")
                    }
                }
            }
        )
    }

    @Composable
    fun SimpleSnackbarComponent() {
        val snackbarVisibleState = remember { mutableStateOf(false) }

        Button(onClick = { snackbarVisibleState.value = !snackbarVisibleState.value }) {
            if (snackbarVisibleState.value) {
                Text("Hide Snackbar")
            } else {
                Text("Show Snackbar")
            }
        }
        if (snackbarVisibleState.value) {
            Snackbar(
                text = { Text(text = "This is a snackbar!") },
                action = {
                    Button(onClick = {}) {
                        Text("MyAction")
                    }
                },
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    @Composable
    fun DropdownDemo() {
        val items = listOf("A", "B", "C", "D", "E", "F")
        val showMenu = remember { mutableStateOf( false ) }
        val selectedIndex = remember { mutableStateOf(0) }

        DropdownMenu(
            toggle = {
                Text(items[selectedIndex.value], modifier = Modifier.fillMaxWidth().padding(16.dp))
            },
            expanded = showMenu.value,
            onDismissRequest = { showMenu.value = false },
            toggleModifier = Modifier.fillMaxWidth().background(Color.Gray).clickable(onClick = { showMenu.value = true }),
            dropdownModifier = Modifier.fillMaxWidth().background(Color.White)
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
    fun SwitchDemo() {
        val checkedState = remember { mutableStateOf(true) }

        Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
        )
    }

    @Composable
    fun ColoredCheckboxComponent() {
        val checkedState = remember { mutableStateOf(true) }

        Row {
            Checkbox(
                checked = checkedState.value,
                modifier = Modifier.padding(16.dp),
                onCheckedChange = { checkedState.value = it }
            )
            Text(text = "Checkbox Example with color", modifier = Modifier.padding(16.dp))
        }
    }

    @Composable
    fun SimpleRadioButtonComponent() {
        val radioOptions = listOf("MindOrks", "AfterAcademy", "CuriousJr")
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }

        Column {
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
    fun ViewItem(
            itemText: String
    ) {
        Card(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color(0xFFCCCCCC),
            modifier = Modifier.clickable(onClick = {
                startActivity(Intent(baseContext, MainActivity::class.java))
            })
        ) {
            Row {
                Text(
                        text = itemText,
                        modifier = Modifier.padding(8.dp),
                        style = TextStyle(
                                fontSize = 24.sp, color = Color.Red),
                        textAlign = TextAlign.Center
                )
                Text(
                        text = itemText,
                        modifier = Modifier.padding(8.dp),
                        style = TextStyle(
                                fontSize = 24.sp, color = Color.Black),
                        textAlign = TextAlign.Center
                )
            }
        }
    }

}