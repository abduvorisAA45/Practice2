package com.example.movieapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.data.data

@Composable
fun CardList(
    items: List<Map<String, Any>>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        items(
            items = items,
            key = { it["id"]!! }
        ) { movie ->
            CardMovie(
                url = movie["poster"]!!.toString(),
                limit = movie["limit"] as Int,
                modifier = Modifier.height(230.dp)
            )
        }
    }
}

@Composable
@Preview
fun CardListPreview() {
    CardList(
        items = data
    )
}