package com.example.movieapp.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun Actors(fullName: String, url: String) {
    Column (
        modifier = Modifier.clickable(onClick = { }) // Event
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .height(180.dp)
                .width(140.dp),
            model = url,
            contentDescription = "actor"
        )
        Text(
            modifier = Modifier.padding(top = 12.dp).width(140.dp),
            text = fullName,
            fontSize = 15.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActorsPreview() {
    Actors("Тим Роббинс","https://static.hdrezka.ac/i/2016/3/10/nea87a365a334yy46g65k.jpg")
}