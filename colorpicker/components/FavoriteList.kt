package com.example.colorpicker.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colorpicker.components.App
import com.example.colorpicker.data.ColorItem


@Composable
fun FavoriteList(
    colors: List<ColorItem>,
    onEdit: (Int) -> Unit,
    onDelete: (Int) -> Unit
) {


    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(10.dp)
            .width(300.dp)
            .height(210.dp)
    ) {
        items(colors) { colorItem ->
            FavoriteItem(
                id = -1,
                data = colorItem.color,
                onEdit = { onEdit(colorItem.id) },
                onDelete = { onDelete(colorItem.id) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteListPreview() {
//    FavoriteList(
//        colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Magenta, Color.DarkGray) ,
//    )
}