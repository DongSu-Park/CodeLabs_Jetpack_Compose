package kr.dev.dspark.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.dev.dspark.artspace.model.ArtItem
import kr.dev.dspark.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var artPos by remember { mutableStateOf(0) }

    val artLists = ArrayList<ArtItem>()
    addArtLists(artLists)

    ArtSpaceLayout(
        artLists[artPos],
        prevClicked = {
            if (artPos > 0) {
                artPos -= 1
            }
        }, nextClicked = {
            if (artPos < artLists.size - 1) {
                artPos += 1
            }
        })
}

fun addArtLists(artLists: ArrayList<ArtItem>) {
    artLists.add(ArtItem(imgRes = R.drawable.open_image_first, title = "Christ Blessing, c. 1310", artist = "Grifo di Tancredi", "c. 1310"))
    artLists.add(ArtItem(imgRes = R.drawable.open_image_second, title = "Madonna and Child Enthroned with Four Saints, c. 1240/1245", artist = "Margaritone d'Arezzo", year = "c. 1240/1245"))
    artLists.add(ArtItem(imgRes = R.drawable.open_image_third, title = "The Calling of the Apostles Peter and Andrew, 1308-1311", artist = "Duccio di Buoninsegna", year = "1308-1311"))
    artLists.add(ArtItem(imgRes = R.drawable.open_image_fourth, title = "Madonna and Child, with the Blessing Christ [middle panel], probably 1340", artist = "Pietro Lorenzetti", year = "probably 1340"))
}

@Composable
fun ArtSpaceLayout(item: ArtItem, prevClicked: () -> Unit, nextClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            border = BorderStroke(width = 4.dp, Color.Gray),
            elevation = 16.dp,
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = item.imgRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .height(400.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Surface(
            elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = item.title,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        ) {
                            append(text = item.artist + " ")
                        }
                        withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraLight)) {
                            append(text = "(" + item.year + ")")
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = prevClicked, modifier = Modifier.width(130.dp)) {
                Text(text = "Previous")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = nextClicked, modifier = Modifier.width(130.dp)) {
                Text(text = "Next")
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true, name = "ArtSpace")
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}