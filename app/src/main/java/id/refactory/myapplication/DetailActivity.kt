package id.refactory.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            supportActionBar?.hide()
            MaterialTheme {
                val fullname = intent?.getStringExtra(MainActivity.KEY_FULLNAME) ?: "-"
                val nickname = intent?.getStringExtra(MainActivity.KEY_NICKNAME) ?: "-"
                val biodata = intent?.getStringExtra(MainActivity.KEY_BIODATA) ?: "-"
                ScaffoldLayout(fullname, nickname, biodata)
            }
        }
    }

    @Composable
    private fun ScaffoldLayout(fullname: String, nickname: String, biodata: String) {
        val redColor = Color.Red
        val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = fullname)
                    },
                    backgroundColor = redColor
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    onBackPressed()
                }) {
                    Text(text = "X")
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            drawerContent = {
                Text(
                    text = "Ini Biodata Atlit, silahkan geser ke kiri...",
                    modifier = Modifier.padding(10.dp)
                )
            },
            bodyContent = {
                Text(text = biodata, modifier = Modifier.padding(7.dp))
            },
            bottomBar = {
                BottomAppBar(backgroundColor = redColor) {
                    Text(text = "julukan: " + nickname)
                }
            }
        )
    }
}