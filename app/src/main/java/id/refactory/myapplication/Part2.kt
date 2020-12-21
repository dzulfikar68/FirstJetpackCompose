package id.refactory.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Part2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(modifier = Modifier.padding(16.dp)) {
                    val image = vectorResource(id = R.drawable.ic_launcher_background)
                    val imageModifier = Modifier
                        .preferredHeight(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp))
                    Image(image, modifier = imageModifier,
                        contentScale = ContentScale.Crop)
                    Spacer(Modifier.preferredHeight(10.dp))
                    Text("Jetpack Compose adalah toolkit modern Android untuk membuat UI native. Jetpack Compose menyederhanakan dan mempercepat pengembangan UI di Android. Buat aplikasi Anda lebih cepat dengan kode yang lebih sedikit, alat yang canggih, dan API Kotlin yang intuitif.",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}