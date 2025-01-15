package com.example.sidenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Menu(navController: NavController){
    val menuWidth =  if( isOpenedMenu )  330.dp else 0.dp

    Column(
        modifier = Modifier
            .width(menuWidth)
            .fillMaxHeight()
            .background(colorBy(
                darkModeOn = Color(59, 58, 58, 255),
                darkModeOff = Color(136, 124, 124, 255)
                )
            )
            .padding(top = 50.dp)
            .zIndex(1f)
            .clickable(enabled = false) {}
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorBy(
                    darkModeOn = Color(246, 56, 11, 255),
                    darkModeOff = Color(238, 188, 89, 255
                    )
                ))
                .height(330.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .clip(shape = RoundedCornerShape(65.dp))
                    .background(Color.Green)
                    .padding(vertical = 10.dp)
                ,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorBy(
                        darkModeOn = Color(59, 58, 58, 255),
                        darkModeOff = Color(136, 124, 124, 255)
                    )
                )
                    .padding(start = 25.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                listOf(Name, Surname).forEach {
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = it.value.value,
                        modifier = Modifier
                            .height(40.dp)
                            .clickable {
                                personalInfoType = it
                                isTextEditing = true
                            },
                        color = colorBy(
                            darkModeOn = Color.White,
                            darkModeOff = Color.Black
                        ),
                        fontSize = 35.sp
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .height(720.9.dp)
                .fillMaxWidth()
                .background(
                    colorBy(
                        darkModeOn = Color(59, 58, 58, 255),
                        darkModeOff = Color(136, 124, 124, 255)
                    )
                )
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate(Settings) { launchSingleTop = true } },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Sharp.Settings,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    tint = colorBy(
                        darkModeOn = Color.White,
                        darkModeOff = Color(145, 105, 85, 255)
                    )
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            var checked by remember { mutableStateOf(false) }
            Switch(
                checked = checked,
                onCheckedChange = {
                    isDarkMode = it
                    checked = !checked
                },
                enabled = menuWidth != 0.dp,
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Color.Red,
                    disabledUncheckedTrackColor = Color.Transparent,
                    disabledCheckedIconColor = Color.Transparent,
                    disabledCheckedThumbColor = Color.Transparent,
                    disabledCheckedTrackColor = Color.Transparent,
                    disabledCheckedBorderColor = Color.Transparent,
                    disabledUncheckedIconColor = Color.Transparent,
                    disabledUncheckedThumbColor = Color.Transparent,
                    disabledUncheckedBorderColor = Color.Transparent,
                )
            )
        }
    }
}


@Preview(device = "spec:width=392.7dp,height=850.9dp,dpi=440")
@Composable
fun MenuPreview(){
    Menu(navController = rememberNavController())
}