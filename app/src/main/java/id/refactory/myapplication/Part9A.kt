package id.refactory.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Part9A : AppCompatActivity() {

    companion object {
        const val KEY_FULLNAME = "fullname"
        const val KEY_NICKNAME = "nickname"
        const val KEY_BIODATA = "biodata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                supportActionBar?.hide()

                val drawerState = rememberDrawerState(DrawerValue.Closed)
                ModalDrawerLayout(
                    drawerState = drawerState,
                    drawerContent = {
                        Column {
                            Text(text = "Hello Dunia!",
                                modifier = Modifier.padding(8.dp),
                                style = TextStyle(
                                    fontSize = 24.sp, color = Color.Black
                                )
                            )
                            Button(onClick = { drawerState.close() }) {
                                Text("Tutup Drawer")
                            }
                        }
                    },
                    bodyContent = { ListItem() }
                )
            }
        }
    }

    val listOrang = listOf(
        mapOf(
            KEY_FULLNAME to "Abi",
            KEY_NICKNAME to "a",
            KEY_BIODATA to "x"
        ),
        mapOf(
            KEY_FULLNAME to "Umi",
            KEY_NICKNAME to "u",
            KEY_BIODATA to "y"
        ),
        mapOf(
            KEY_FULLNAME to "Eyang",
            KEY_NICKNAME to "e",
            KEY_BIODATA to "z"
        )
    )

    @Composable
    fun ListItem() {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "List Biodata Orang")
            Spacer(Modifier.preferredHeight(10.dp))
            LazyColumn {
                items(
                    items = listOrang,
                    itemContent = { item ->
                        ViewItem(
                            fullname = item[KEY_FULLNAME] ?: "-",
                            nickname = item[KEY_NICKNAME] ?: "-",
                            biodata = item[KEY_BIODATA] ?: "-"
                        )
                    }
                )
            }
        }
    }

    @Composable
    fun ViewItem(
        fullname: String,
        nickname: String,
        biodata: String
    ) {
        Card(
            shape = RoundedCornerShape(5.dp),
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 5.dp,
            modifier = Modifier.padding(5.dp).clickable(onClick = {
                startActivity(
                    Intent(baseContext, Part9B::class.java)
                        .putExtra(KEY_FULLNAME, fullname)
                        .putExtra(KEY_NICKNAME, nickname)
                        .putExtra(KEY_BIODATA, biodata)
                )
            })
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = fullname,
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(
                        fontSize = 24.sp, color = Color.Blue),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "($nickname)",
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(
                        fontSize = 24.sp, color = Color.Red),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}