package com.example.colorpicker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColorBox(color: Color) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = CircleShape
            )
            .clip(CircleShape)
            .background(color = color)
    )
}

@Preview
@Composable
fun ColorBoxPreview() {
    ColorBox(Color.Red)
}