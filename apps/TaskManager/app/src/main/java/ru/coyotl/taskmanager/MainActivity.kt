package ru.coyotl.taskmanager

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.coyotl.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowNotification(
                        stringResource(id = R.string.completed),
                        stringResource(id = R.string.nice)
                    )
                }
            }
        }
    }
}

@SuppressLint("PrivateResource")
@Composable
fun ShowNotification(firstText: String, secondText: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image (
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null,
            modifier = Modifier.width(200.dp)
        )
        Text (
            text = firstText,
            modifier = Modifier
                .padding(
                    0.dp,
                    24.dp,
                    0.dp,
                    8.dp
                ),
            fontWeight = FontWeight.Bold,
        )
        Text (
            text = secondText,
            fontSize = 16.sp,
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        ShowNotification(
            stringResource(id = R.string.completed),
            stringResource(id = R.string.nice)
        )
    }
}