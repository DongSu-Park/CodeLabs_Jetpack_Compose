package kr.dev.dspark.textcomposables

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.dev.dspark.textcomposables.ui.theme.TextComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextComposablesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(
                        msg = getString(R.string.happy_birthday_text),
                        from = getString(R.string.signature_text)
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(msg: String, from: String) {
    // Text Composable 만들고 text, fontSize 지정 하여 재사용 처리
    // Column 으로 행으로 처리 (vertical 방향으로)
    Column {
        Text(
            text = msg,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp)
        )

        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(msg: String, from: String) {
    // 이미지 리소스
    val image = painterResource(id = R.drawable.androidparty)

    // painter -> 표시할 이미지 객체, contentDescription -> 이미지 설명 (talkback 기능)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(msg = msg, from = from)
    }
}


@Preview(showSystemUi = true, showBackground = true, name = "My Preview")
@Composable
fun BirthdayCardPreview() {
    // Composable 함수 이름의 첫 글자는 대문자 (파스칼 표기법)
    TextComposablesTheme() {
//        BirthdayGreetingWithText(msg = "Happy Birthday Sam!", from = "- from Emma")
        BirthdayGreetingWithImage(msg = "Happy Birthday Sam!", from = "- from Emma")
    }
}