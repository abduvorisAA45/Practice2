package com.example.sidenavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuLenta(){
    TopAppBar(
        title = {},
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(115.dp)
                    .padding(top = 7.5.dp, bottom = 7.5.dp)
                    .clickable { isOpenedMenu = true },
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
        ,
        colors = TopAppBarColors(
            containerColor = colorBy(
                darkModeOff = Color(173, 239, 113, 255),
                darkModeOn = Color(34, 64, 86, 255)
            ),
            scrolledContainerColor = Color.Blue,
            navigationIconContentColor = colorBy(
                darkModeOff = Color.White,
                darkModeOn = Color.Red
            ),
            titleContentColor = Color.Yellow,
            actionIconContentColor = Color.Magenta
        ),
    )
}


@Preview
@Composable
fun MenuLentaPreview(){
    MenuLenta()
}