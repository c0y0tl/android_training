package ru.coyotl.businesscard

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
                    DescriptionCard(
                        painter = painterResource(id = R.drawable.coyotl),
                        name = "Sergei",
                        surname = "Korablev",
                        title = "c0y0tl"
                    )
                    ContactsCard(
                        phone = "+X-XXX-XXX-XX-XX",
                        email = "jres.kor@gmail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun DescriptionCard(painter: Painter, name: String, surname: String, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painter,
            contentDescription = "$name $surname",
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "$name $surname",
            modifier = modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = modifier.align(Alignment.CenterHorizontally),
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
fun ContactsCard(phone: String, email: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(10.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = modifier
                .width(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_call_24),
                contentDescription = "Телефон",
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_email_24),
                contentDescription = "Электронная почта"
            )
        }
        Column(
        ) {
            Text(
                text = phone
            )
            Text(
                text = email
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