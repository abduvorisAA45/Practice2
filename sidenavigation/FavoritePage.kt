package com.example.sidenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun FavoritePage(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorBy(
                darkModeOff = Color(241, 171, 171, 255),
                darkModeOn = Color(82, 171, 171, 255)
            ))
        ,
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Favorite",
            fontSize = 50.sp,
            color = colorBy(
                darkModeOn = Color.White,
                darkModeOff = Color.Black
            ),
        )
    }
}

@Preview
@Composable
fun FavoritePagePreview(){
    FavoritePage()
}