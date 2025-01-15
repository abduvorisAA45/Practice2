package com.example.movieapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.floor




@Composable
fun RateSlider(
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        RangeSlider(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.padding(top = 20.dp),
            valueRange = 1f..10f,
            colors = SliderDefaults.colors(
                thumbColor = Color(236, 84, 7, 255),
                activeTrackColor = Color(236, 84, 7, 255),
                activeTickColor = Color.Green,
                inactiveTickColor = Color.Gray,
                inactiveTrackColor = Color.Gray
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp, start = 10.dp, bottom = 20.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf(value.start, value.endInclusive)
                .forEach {
                    Text(text = "${floor(it * 100.0) / 100.0}", fontSize = 25.sp, color = Color.Black)
                }
        }
    }
}

@Preview(showBackground = true, device = "spec:width=392.7dp,height=850.9dp,dpi=440")
@Composable
fun RateSliderPreview() {
    var rateView by remember { mutableStateOf(1f..10f) }
    RateSlider(
        value = rateView,
        onValueChange = { newRange -> rateView = newRange }
    )
}