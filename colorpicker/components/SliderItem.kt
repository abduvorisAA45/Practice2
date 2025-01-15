package com.example.colorpicker.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderItem(
    property: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    thumbColor: Color = Color.Black,
    trackColor: Color = Color.Black
) {
    Column(
        modifier = Modifier
            .width(300.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = property,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${(value * 255).toInt()}",
                fontWeight = FontWeight.Bold
            )
        }
        Slider(
            value = value,
            onValueChange = onValueChange,
            colors = SliderDefaults.colors(
                thumbColor = thumbColor,
                activeTrackColor = trackColor,
                inactiveTrackColor = Color.LightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SliderItemPreview() {
    var input by remember { mutableFloatStateOf(0f) }

    SliderItem(
        value = input,
        onValueChange = { input = it },
        property = "Red",
        thumbColor = Color.Red,
        trackColor = Color.Red
    )
}