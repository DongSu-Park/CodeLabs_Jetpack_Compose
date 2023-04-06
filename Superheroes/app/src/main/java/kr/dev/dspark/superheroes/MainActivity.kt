package kr.dev.dspark.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.dev.dspark.superheroes.model.Hero
import kr.dev.dspark.superheroes.repository.HeroesRepository
import kr.dev.dspark.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperHeroes()
                }
            }
        }
    }
}

@Composable
fun SuperHeroes() {
    Scaffold(topBar = { SuperHeroesTopBar() }) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(paddingValues)
        ) {
            items(HeroesRepository.heroes) {
                SuperHeroesCard(heroItem = it)
            }
        }
    }
}

@Composable
fun SuperHeroesTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(56.dp), contentAlignment = Alignment.Center
    ) {
        Text(text = "Superheroes", style = MaterialTheme.typography.h1)
    }
}

@Composable
fun SuperHeroesCard(heroItem: Hero) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = heroItem.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(id = heroItem.descriptionRes),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(8))
                    .size(72.dp),
                painter = painterResource(id = heroItem.imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroesCardPreview() {
    SuperHeroesTheme(darkTheme = false) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .sizeIn(minHeight = 72.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(id = R.string.hero1),
                        style = MaterialTheme.typography.h3
                    )
                    Text(
                        text = stringResource(id = R.string.description3),
                        style = MaterialTheme.typography.body1
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8))
                        .size(72.dp),
                    painter = painterResource(id = R.drawable.android_superhero1),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroesTopBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(56.dp), contentAlignment = Alignment.Center
    ) {
        Text(text = "Superheroes", style = MaterialTheme.typography.h1)
    }
}