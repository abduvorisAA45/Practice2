package com.example.movieapp.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.movieapp.data.data
import com.example.movieapp.ui.components.Actors
import com.example.movieapp.ui.components.HorizontalCardList
import com.example.movieapp.data.data

val backgroundColor = Color(25, 25, 25, 255)

@Composable
fun MoviePage(movie: Map<String, Any>, innerPadding: PaddingValues) {
    val moviePosterUrl = movie["big poster"]!! as String
    val genres = movie["genre"]!! as List<String>
    val countries = movie["country"]!! as List<String>
    val actors = movie["actors"]!! as List<Pair<String, String>>
    val similarMovies = data.filter { movieData ->
        val genre = movieData["genre"]!! as List<String>
        genres.contains(genre[0])
    }.take(10)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(415.dp)
        ) {
            AsyncImage(
                model = moviePosterUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        alpha = 0.45f
                    },
                contentScale = ContentScale.Crop
            )
            AsyncImage(
                model = moviePosterUrl,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(270.dp)
                    .width(220.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(2.dp, Color.White, RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillBounds
            )

        }
        HorizontalDivider(thickness = 3.dp, color = Color.Gray)
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = movie["name"] as String,
                fontWeight = FontWeight.W500,
                fontSize = 25.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = genres.joinToString(", "),
                fontSize = 15.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(
                    text = movie["year"].toString() + ", "
                            + movie["limit"].toString() + "+, "
                            + movie["rating"].toString(),
                    fontSize = 15.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(1.dp))
                Icon(
                    modifier = Modifier.height(17.dp),
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Color.Yellow
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = countries.joinToString(", "),
                fontSize = 15.sp,
                color = Color.White
            )
        }
        Text(
            modifier = Modifier.padding(start = 7.dp, top = 10.dp),
            text = "Описание:",
            fontSize = 15.sp,
            color = Color.White
        )
        Text(
            modifier = Modifier.padding(start = 7.dp, top = 7.dp).fillMaxWidth(),
            text = movie["description"].toString(),
            fontSize = 15.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier.height(50.dp)
                .width(220.dp)
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(7.dp))
                .background(Color(117, 74, 74, 255))
                .clickable(onClick = { }),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Смотреть",
                fontSize = 25.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(start = 7.dp, bottom = 3.dp),
            text = "В ролях:",
            color = Color.White
        )
        LazyRow {
            items(items = actors) { (fullName, url) ->
                Actors(
                    fullName = fullName,
                    url = url
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalCardList(
            title = "Похожие фильмы:",
            items = similarMovies
        )
        Spacer(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding() + 10.dp))
    }
}
@Preview(showBackground = true)
@Composable
fun MoviePagePreview() {
    MoviePage(data[0], PaddingValues(25.dp))
}