package kr.dev.dspark.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.dev.dspark.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeGreeting(description: String, imageResource: Painter, onClicked: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = description, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = imageResource, contentDescription = null,
            modifier = Modifier
                .border(
                    border = BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable(onClick = onClicked)
        )
    }
}

@Composable
fun LemonadeApp() {
    var cntStep by remember {
        mutableStateOf(1)
    }

    var squeezeStep by remember {
        mutableStateOf(0)
    }

    when (cntStep) {
        1 -> {
            LemonadeGreeting(
                description = stringResource(id = R.string.text_display_first_description),
                imageResource = painterResource(id = R.drawable.lemon_tree)
            ) {
                cntStep = 2
                squeezeStep = (2..4).random()
            }
        }

        2 -> {
            LemonadeGreeting(
                description = stringResource(id = R.string.text_display_second_description),
                imageResource = painterResource(id = R.drawable.lemon_squeeze)
            ) {
                if (squeezeStep == 0) {
                    cntStep = 3
                } else {
                    squeezeStep -= 1
                }
            }
        }

        3 -> {
            LemonadeGreeting(
                description = stringResource(id = R.string.text_display_third_description),
                imageResource = painterResource(id = R.drawable.lemon_drink)
            ) {
                cntStep = 4
            }
        }

        4 -> {
            LemonadeGreeting(
                description = stringResource(id = R.string.text_display_fourth_description),
                imageResource = painterResource(id = R.drawable.lemon_restart)
            ) {
                cntStep = 1
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, name = "LemonadeApp")
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}