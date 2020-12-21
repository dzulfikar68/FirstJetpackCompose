package id.refactory.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class Part9B : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            supportActionBar?.hide()
            MaterialTheme {
                val fullname = intent?.getStringExtra(Part9A.KEY_FULLNAME) ?: "-"
                val nickname = intent?.getStringExtra(Part9A.KEY_NICKNAME) ?: "-"
                val biodata = intent?.getStringExtra(Part9A.KEY_BIODATA) ?: "-"
                ScaffoldLayout(fullname, nickname, biodata)
            }
        }
    }

    @Composable
    fun ScaffoldLayout(fullname: String, nickname: String, biodata: String) {
        val redColor = Color.Red
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = {
                        Text(fullname)
                    },
                    backgroundColor = redColor
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    onBackPressed()
                }) {
                    Text("X")
                }
            },
            drawerContent = {


                Text(text = "Ini Biodata Orang, silahkan geser ke kiri...",
                    modifier = Modifier.padding(10.dp)
                )
            },
            bodyContent = {
                Text(
                    text = biodata,
                    modifier = Modifier.padding(7.dp)
                )
            },
            bottomBar = { BottomAppBar(backgroundColor = redColor) { Text("panggilannya: $nickname") } }
        )
    }
}