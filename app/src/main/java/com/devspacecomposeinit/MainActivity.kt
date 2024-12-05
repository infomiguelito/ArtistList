package com.devspacecomposeinit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devspacecomposeinit.ui.theme.ComposeInitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeInitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val leonardo = Artist(
                        art = R.drawable.ic_mona_lisa,
                        image = R.drawable.ic_leonardo_da_vinci,
                        name = "Leonardo da Vinci",
                        lastsenonline = " 3 minutes ago"
                    )

                    val picasso = Artist(
                        art = R.drawable.ic_beijo,
                        image = R.drawable.ic_pablo_picasso,
                        name = "Pablo Picasso",
                        lastsenonline = " 7 minutes ago"
                    )

                    val salvador = Artist(
                        art = R.drawable.ic_persistence_of_memory,
                        image = R.drawable.ic_salvador_dali,
                        name = "Salvador Dali",
                        lastsenonline = " 6 minutes ago"
                    )

                    val Gogh = Artist(
                        art = R.drawable.ic_starry_night,
                        image = R.drawable.ic_vincent_van_gogh,
                        name = "Vicent Van Gogh",
                        lastsenonline = " 20 minutes ago"
                    )

                    val artists = listOf(Gogh, picasso, salvador, leonardo)

                    LazyColumn {
                        items(artists) { artist ->
                            ArtistCard(
                                artist = artist,
                                onClick = {
                                    println("miguel teste" + artist.name)
                                }
                            )

                        }

                    }
                }

            }
        }
    }
}



@Composable
fun ArtistCard(
    artist: Artist,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Row {
            Image(
                painter = painterResource(id = artist.image),
                contentDescription = "Artist image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(
                    text = artist.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = artist.lastsenonline,
                    color = Color.Gray
                )
            }

        }
        Card(
            modifier = Modifier
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = artist.art),
                contentDescription = "Art Artist"
            )

        }
    }
}

data class Artist(
    val name: String,
    val lastsenonline: String,
    @DrawableRes val image: Int,
    @DrawableRes val art: Int
)


@Preview(showBackground = true)
@Composable
fun ArtistCardPreview() {
    ComposeInitTheme {
        val artist = Artist(
            name = "Leonardo da Vinci",
            lastsenonline = " 3 minutes ago",
            image = R.drawable.ic_leonardo_da_vinci,
            art = R.drawable.ic_mona_lisa,
        )
        ArtistCard(artist = artist,
            onClick = {

            }
        )
    }
}


