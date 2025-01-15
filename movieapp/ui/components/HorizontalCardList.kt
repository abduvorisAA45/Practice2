package com.example.movieapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.data.data
import com.example.movieapp.ui.components.CardMovie

@Composable
fun HorizontalCardList(
    title: String,
    items: List<Map<String, Any>>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            TextButton(
                onClick = { }
            ) {
                Text(
                    text = "еще"
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            items.forEach { item ->
                CardMovie(
                    url = item["poster"] as String,
                    limit = item["limit"] as Int,
                    modifier = Modifier
                        .height(180.dp)
                        .width(140.dp)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HorizontalCardListPreview() {
    HorizontalCardList(
        title = "Похожие фильмы",
        items = data.slice(1..10),
        modifier = Modifier.background(Color.Black)
    )
}