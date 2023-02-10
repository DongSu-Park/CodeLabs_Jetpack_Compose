package kr.dev.dspark.affirmation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.dev.dspark.affirmation.data.DataSource
import kr.dev.dspark.affirmation.model.Affirmation
import kr.dev.dspark.affirmation.ui.theme.AffirmationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AffirmationScroller()
                }
            }
        }
    }
}

@Composable
fun AffirmationScroller() {
    val context = LocalContext.current
    val mockLists = DataSource().loadAffirmations()
    LazyColumn {
        items(mockLists) { items ->
            AffirmationCard(items) {
                Toast.makeText(
                    context,
                    "Clicked = ${context.resources.getString(items.stringResId)}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AffirmationCard(items: Affirmation, onClicked: () -> Unit) {
    Card(modifier = Modifier.padding(8.dp), elevation = 10.dp, onClick = onClicked) {
        Column {
            Image(
                painter = painterResource(id = items.imgResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = items.stringResId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AffirmationTheme {
        val mockLists = DataSource().loadAffirmations()
        LazyColumn() {
            items(mockLists) { items ->
                AffirmationCard(items) {

                }
            }
        }
    }
}