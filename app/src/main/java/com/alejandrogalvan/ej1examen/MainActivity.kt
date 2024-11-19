package com.alejandrogalvan.ej1examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alejandrogalvan.ej1examen.ui.theme.Ej1ExamenTheme

data class VideoGame(val name: String, val price: Double, val imageUrl: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ej1ExamenTheme {
                VideoGameList(
                    games = listOf(
                        VideoGame("Game 1", 59.99, "https://loremflickr.com/400/400/seville?lock=1"),
                        VideoGame("Game 2", 49.99, "https://loremflickr.com/400/400/seville?lock=2"),
                        VideoGame("Game 3", 39.99, "https://loremflickr.com/400/400/seville?lock=3")
                    )
                )
            }
        }
    }
}

@Composable
fun VideoGameList(games: List<VideoGame>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(games) { game ->
            VideoGameCard(name = game.name, price = game.price, imageUrl = game.imageUrl)
        }
    }
}

@Composable
fun VideoGameCard(name: String, price: Double, imageUrl: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(text = "$name - $price", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Price: $price", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ej1ExamenTheme {
        VideoGameList(
            games = listOf(
                VideoGame("Game 1", 59.99, "https://loremflickr.com/400/400/seville?lock=1"),
                VideoGame("Game 2", 49.99, "https://loremflickr.com/400/400/seville?lock=2"),
                VideoGame("Game 3", 39.99, "https://loremflickr.com/400/400/seville?lock=3")
            )
        )
    }
}