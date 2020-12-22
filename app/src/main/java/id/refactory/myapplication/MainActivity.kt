package id.refactory.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {

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
                            Text(
                                text = "Hello Dunia!",
                                modifier = Modifier.padding(8.dp),
                                style = TextStyle(
                                    fontSize = 24.sp, color = Color.Black
                                )
                            )
                            Button(onClick = {
                                drawerState.close()
                            }) {
                                Text(text = "Tutup Drawer")
                            }
                        }
                    },
                    bodyContent = {
                        ListItemAtlit()
                    }
                )
            }
        }
    }

    val listAtlit = listOf(
        mapOf(
            KEY_FULLNAME to "Cristiano Ronaldo",
            KEY_NICKNAME to "CR7",
            KEY_BIODATA to "Cristiano Ronaldo lahir di Funchal, Madeira, Portugal pada 5 Pebruari 1985. Pemain bernama lengkap Cristiano Ronaldo dos Santos Aveiro itu memegang rekor sebagai pemain termahal di dunia ketika ditransfer Real Madrid dari Manchester United pada musim panas 2009 senilai 132 juta dolar atau lebih dari 1,3 triliun rupiah."
        ),
        mapOf(
            KEY_FULLNAME to "Valentino Rossi",
            KEY_NICKNAME to "the doctor",
            KEY_BIODATA to "Nama Valentino Rossi memang sungguh besar di ajang MotoGP dunia. Disebut – sebut bahwa Valentino Rossi merupakan salah satu pembalap terbaik sepanjang masa. Ia adalah salah satu pembalap tersukses sepanjang masa yang sudah menyabet 10 gelar juara MotoGP dunia. Masing – masing gelar tersebut terbagi menjadi 7 gelar juara dunia di kelas puncak MotoGP, dua gelar juara dunia di kelas 250 cc dan juara dunia di kelas 125 cc."
        ),
        mapOf(
            KEY_FULLNAME to "Khabib Nurmagomedov",
            KEY_NICKNAME to "The Eagle",
            KEY_BIODATA to "Khabib adalah seniman bela diri campuran profesional Rusia keturunan etnis Avar. Nurmagomedov adalah Juara Dunia Combat Sambo dan dua kali Juara UFC kelas ringan. Dia saat ini memegang rekor tak terkalahkan terpanjang di MMA, dengan 29 kemenangan, dan tetap tak terkalahkan dalam MMA profesional. Ia berasal dari wilayah Dagestan Rusia, dan merupakan orang Rusia pertama dan Muslim pertama yang memenangkan gelar UFC. Pertarungan terbesarnya dengan Conor McGregor di UFC 229 menarik 2,4 juta Bayar-per-tayang , yang paling banyak untuk acara MMA. Per 2 Januari 2019, dia berada di peringkat ke-3 UFC pound-for-pound ."
        )
    )

    @Composable
    private fun ListItemAtlit() {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "List Biodata Atlit")
            Spacer(modifier = Modifier.preferredHeight(10.dp))
            LazyColumn {
                items(
                    items = listAtlit,
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
    private fun ViewItem(
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
                    Intent(baseContext, DetailActivity::class.java)
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
                        fontSize = 24.sp, color = Color.Blue
                    )
                )
                Text(
                    text = "($nickname)",
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(
                        fontSize = 24.sp, color = Color.Red
                    )
                )
            }
        }
    }

}