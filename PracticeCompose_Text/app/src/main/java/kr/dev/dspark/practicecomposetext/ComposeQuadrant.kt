package kr.dev.dspark.practicecomposetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.dev.dspark.practicecomposetext.ui.theme.PracticeComposeTextTheme

class ComposeQuadrant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeComposeTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QuadrantGreeting()
                }
            }
        }
    }
}

@Composable
fun QuadrantGreeting() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            OneWayCardGreeting(
                Modifier.weight(1f),
                stringResource(id = R.string.quadrant_first_title),
                stringResource(id = R.string.quadrant_first_msg),
                Color.Green
            )
            OneWayCardGreeting(
                Modifier.weight(1f),
                stringResource(id = R.string.quadrant_second_title),
                stringResource(id = R.string.quadrant_second_msg),
                Color.Yellow
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            OneWayCardGreeting(
                Modifier.weight(1f),
                stringResource(id = R.string.quadrant_third_title),
                stringResource(id = R.string.quadrant_third_msg),
                Color.Cyan
            )
            OneWayCardGreeting(
                Modifier.weight(1f),
                stringResource(id = R.string.quadrant_fourth_title),
                stringResource(id = R.string.quadrant_fourth_msg),
                Color.LightGray
            )
        }
    }
}

@Composable
private fun OneWayCardGreeting(modifier: Modifier, title: String, msg: String, bgColor: Color) {
    Column(
        modifier = modifier
            .background(color = bgColor)
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = msg,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showSystemUi = true, showBackground = true, name = "QuadrantLayout")
@Composable
fun QuadrantPreview() {
    PracticeComposeTextTheme {
        QuadrantGreeting()
    }
}