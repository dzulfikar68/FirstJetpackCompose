package id.refactory.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

class Part3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Row(modifier = Modifier.padding(16.dp)) {
                    Button(onClick = {
                        Toast.makeText(baseContext, "Hello Dunia", Toast.LENGTH_SHORT).show()
                    }) {
                        Text("Klik disini!")
                    }
                    Spacer(Modifier.width(10.dp))
                    IconButton(onClick = { finish() }) {
                        Image(imageVector = vectorResource(id = R.drawable.ic_android_black_24dp))
                    }
                }
            }
        }
    }
}