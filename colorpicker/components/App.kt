package com.example.colorpicker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.colorpicker.data.ColorItem
import com.example.colorpicker.viewmodel.SliderColorData




@Composable
fun App() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {

        val red by remember { mutableStateOf(SliderColorData()) }
        val green by remember { mutableStateOf(SliderColorData()) }
        val blue by remember { mutableStateOf(SliderColorData()) }

        var color by remember { mutableStateOf(Color(red.value, green.value, blue.value)) }

        var savedColors by remember { mutableStateOf(listOf<ColorItem>()) }
        var id by remember { mutableIntStateOf(0) }
        var isEditProcess by remember { mutableStateOf(false) }
        var editingId by remember { mutableIntStateOf(-1) }


        // methods

        val onAddOrEdit = {

            if( isEditProcess ){
                savedColors = savedColors.map { colorItem ->
                    if( editingId == colorItem.id ) {
                        editingId = -1
                        isEditProcess = false
                        colorItem.copy(color = color)
                    }
                    else
                        colorItem
                }
            }
            else {
                savedColors =
                    listOf(
                        ColorItem(
                            color = Color(red.value, green.value, blue.value, 1f),
                            id = id
                        )
                    ) + savedColors
                id += 1
            }
        }

        val onEdit = {
            thisId: Int  ->

            savedColors = savedColors.map { colorItem ->
                if( colorItem.id == thisId ) {
                    color = colorItem.color
                    isEditProcess = true
                    editingId = thisId
                    red.value = colorItem.color.red
                    green.value = colorItem.color.green
                    blue.value = colorItem.color.blue
                }
                    colorItem
            }
        }

        val onDelete = {
            thisId: Int ->

            for( colorIndex in savedColors.indices ){
                if( savedColors[colorIndex].id == thisId ){
                    savedColors =
                        savedColors.slice(0..<colorIndex) +
                        savedColors.slice(colorIndex + 1..savedColors.lastIndex)

                    break
                }
            }

        }

        ColorBox(color = color)
        Spacer(modifier = Modifier.height(25.dp))


        SliderItem(
            property = "Red",
            value = red.value,
            onValueChange = {
                red.value = it
                color = color.copy(red = it)
            }
        )
        SliderItem(
            property = "Green",
            value = green.value,
            onValueChange = {
                green.value = it
                color = color.copy(green = it)
            }
        )
        SliderItem(
            property = "Blue",
            value = blue.value,
            onValueChange = {
                blue.value = it
                color = color.copy(blue = it)
            }
        )

        CustomButton(
            onClick = { onAddOrEdit() }
        ) {
            Icon(
                imageVector =
                if( isEditProcess )
                    Icons.Rounded.Edit
                else
                    Icons.Rounded.Add
                ,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .background(
                        if( isEditProcess )
                            Color.Blue
                        else
                            Color.DarkGray
                    )
                    .padding(10.dp)
                    .size(80.dp, 25.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        FavoriteList(
            colors = savedColors,
            onEdit = onEdit,
            onDelete = onDelete
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App()
}