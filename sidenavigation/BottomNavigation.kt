package com.example.sidenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigation(
    navController: NavController
){

    val navigationList = listOf(
        Icons.Rounded.Home to remember { mutableStateOf(true) },
        Icons.Rounded.Favorite to remember { mutableStateOf( false) },
        Icons.Rounded.Notifications to remember { mutableStateOf(false) }
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(colorBy(
                darkModeOff = Color.Cyan,
                darkModeOn = Color(34, 64, 86, 255)
            )
        )
        ,
    ){
        navigationList.forEach { pair ->
            val (icon, isSelected) = pair

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        navigationList.forEach { pair -> pair.second.value = icon == pair.first }

                        when ( icon ){
                            Icons.Rounded.Home -> navController.navigate(Home) { launchSingleTop = true }
                            Icons.Rounded.Favorite -> navController.navigate(Favorite) { launchSingleTop = true }
                            Icons.Rounded.Notifications -> navController.navigate(Notifications) { launchSingleTop = true }
                        }
                    }
                ,
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    tint = if( isSelected.value )
                        colorBy(
                            darkModeOff = Color.Yellow,
                            darkModeOn = Color.Red
                        )
                    else
                        Color.Black
                )
            }
        }
    }

}




@Preview
@Composable
fun BottomNavigationPreview(){
    BottomNavigation(rememberNavController())
}