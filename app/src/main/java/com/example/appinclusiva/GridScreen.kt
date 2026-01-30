package com.example.appinclusiva

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun GridScreen() {

    val context = LocalContext.current
    val screenWidth = LocalConfiguration.current.screenWidthDp

    val columns = when {
        screenWidth < 600 -> 2
        screenWidth < 840 -> 3
        else -> 4
    }

    val images = listOf(
        "https://picsum.photos/300/200?1",
        "https://picsum.photos/300/200?2",
        "https://picsum.photos/300/200?3",
        "https://picsum.photos/300/200?4",
        "https://picsum.photos/300/200?5",
        "https://picsum.photos/300/200?6"
    )

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Grilla adaptativa (Semana 3)",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(images) { url ->
                Card {
                    Column {
                        AsyncImage(
                            model = url,
                            contentDescription = "Imagen desde internet",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp),
                            contentScale = ContentScale.Crop
                        )

                        TextButton(
                            onClick = {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://www.uilever.com/")
                                )
                                context.startActivity(intent)
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Abrir link")
                        }
                    }
                }
            }
        }
    }
}