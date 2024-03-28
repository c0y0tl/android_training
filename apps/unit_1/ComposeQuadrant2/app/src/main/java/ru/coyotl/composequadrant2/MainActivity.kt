package ru.coyotl.composequadrant2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.coyotl.composequadrant2.ui.theme.ComposeQuadrant2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrant2Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant() {
    Column {
        Row(Modifier.weight(1f)) {
            QuadrantContent(stringResource(R.string.text_composable),
                stringResource(R.string.text_description), Color(0xFFEADDFF), modifier = Modifier.weight(1f))
            QuadrantContent(stringResource(R.string.image_composable),
                stringResource(R.string.image_description), Color(0xFFD0BCFF), modifier = Modifier.weight(1f))
        }
        Row(Modifier.weight(1f)) {
            QuadrantContent(stringResource(R.string.row_composable),
                stringResource(R.string.row_description), Color(0xFFB69DF8), modifier = Modifier.weight(1f))
            QuadrantContent(stringResource(R.string.column_composable),
                stringResource(R.string.column_description), Color(0xFFF6EDFF), modifier = Modifier.weight(1f))
        }
    }
}


@Composable
fun QuadrantContent(title: String, description: String, bg: Color, modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(bg)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrant2Theme {
        ComposeQuadrant()
    }
}