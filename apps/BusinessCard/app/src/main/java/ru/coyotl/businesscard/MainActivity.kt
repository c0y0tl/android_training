package ru.coyotl.businesscard

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.coyotl.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.background(Color(0xFFF2F2F2))
    ) {
        BusinessCardAbout("Sergei Korablev", "coyotl", painterResource(id = R.drawable.coyotl))
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        BusinessCardContacts("c0y0tl", "jres.kor@gmail.com")
    }
}

@Composable
fun BusinessCardAbout(name: String, nickname: String, painter: Painter, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Light,
            fontSize = 35.sp,
        )
        Text(
            text = nickname,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
    }
}

@Composable
fun BusinessCardContacts(twitch: String, email: String, modifier: Modifier = Modifier) {
    Column() {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.email),
                contentDescription = "Email",
            )
            Text(
                text = email,
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.twitch),
                contentDescription = "Email",
            )
            Text(
                text = twitch,
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {

    }
}