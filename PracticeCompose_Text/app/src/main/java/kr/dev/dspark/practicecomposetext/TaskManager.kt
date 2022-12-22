package kr.dev.dspark.practicecomposetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.dev.dspark.practicecomposetext.ui.theme.PracticeComposeTextTheme

class TaskManager : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeComposeTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TaskManagerGreeting(
                        msg1 = stringResource(R.string.task_msg1),
                        msg2 = stringResource(R.string.task_msg2)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskManagerGreeting(msg1: String, msg2: String) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = msg1,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = msg2,
            fontSize = 16.sp
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, name = "TaskManager")
@Composable
fun TaskManagerPreview() {
    PracticeComposeTextTheme() {
        TaskManagerGreeting(
            msg1 = stringResource(R.string.task_msg1),
            msg2 = stringResource(R.string.task_msg2)
        )
    }
}