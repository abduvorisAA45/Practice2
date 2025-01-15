package com.example.colorpicker.data

import androidx.compose.ui.graphics.Color

data class ColorPickerData(
    val color: Color = Color.Black,
    val selectId: Int? = null,
    val colorList: List<ColorItem> = listOf(
        ColorItem(id = 1, color = Color(1f, 0f, 0f)),
        ColorItem(id = 1, color = Color(0f, 0f, 1f))
    )
)