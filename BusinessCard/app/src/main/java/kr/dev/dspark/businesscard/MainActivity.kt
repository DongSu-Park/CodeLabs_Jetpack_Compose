package kr.dev.dspark.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.dev.dspark.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardGreeting()
                }
            }
        }
    }
}

@Composable
fun BusinessCardGreeting() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 헤더 카드
        HeaderCard(
            painterResource(id = R.drawable.person_icon),
            "Full Name",
            "Career"
        )

        // 간격 조절
        Spacer(modifier = Modifier.height(40.dp))

        // 서브 카드
        Column() {
            SubCard(Icons.Filled.Phone, "+00 (00) 000-000")
            SubCard(Icons.Filled.AccountBox, "@socialmediahandle")
            SubCard(Icons.Filled.Email, "@mail@domain.com")
        }
    }
}

@Composable
fun HeaderCard(imgPainter: Painter, name: String, career: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 프로필 이미지
        Image(
            painter = imgPainter, contentDescription = null, modifier = Modifier
                .width(150.dp)
                .height(100.dp)
        )

        // 프로필 이름
        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp)
        )

        // 프로필 커리어
        Text(
            text = career,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}

@Composable
fun SubCard(iconVector: ImageVector, subMsg: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 앞쪽 간격
        Spacer(modifier = Modifier.width(40.dp))

        // 프로필 서브 정보 아이콘
        Icon(
            imageVector = iconVector,
            contentDescription = null,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
        )

        // 중간 간격
        Spacer(modifier = Modifier.weight(1f))

        // 프로필 서브 정보 내용
        Text(
            text = subMsg,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(end = 40.dp)
                .wrapContentWidth(Alignment.End)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, name = "BusinessCardLayout")
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardGreeting()
    }
}