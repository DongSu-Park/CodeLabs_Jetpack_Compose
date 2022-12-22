package kr.dev.dspark.practicecomposetext

import android.media.tv.interactive.AppLinkInfo
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.dev.dspark.practicecomposetext.ui.theme.PracticeComposeTextTheme

class ComposeHelp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeComposeTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeHelpGreeting(
                        title = stringResource(id = R.string.help_title),
                        msg1 = stringResource(id = R.string.help_msg1),
                        msg2 = stringResource(id = R.string.help_msg2)
                    )
                }
            }
        }
    }
}


@Composable
fun ComposeHelpGreeting(title: String, msg1: String, msg2: String) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = title, fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(text = msg1, modifier = Modifier.padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify)
        Text(text = msg2, modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}

@Preview(showSystemUi = true, showBackground = true, name = "HelpLayout")
@Composable
fun ComposeHelpPreview() {
    PracticeComposeTextTheme() {
        ComposeHelpGreeting(
            title = stringResource(id = R.string.help_title), 
            msg1 = stringResource(id = R.string.help_msg1), 
            msg2 = stringResource(id = R.string.help_msg2)
        )
        
    }
}