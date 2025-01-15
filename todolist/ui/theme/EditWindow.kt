package com.example.todolist.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun EditWindow(
    onConfirm: () -> Unit,
) {
    var editedText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .absoluteOffset(45.dp, 0.dp)
            .requiredSize(300.dp, 450.dp)
            .background(Color.Green)
            .padding(10.dp)
            .zIndex(1f)
        ,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0, 0, 0, 0))
                .padding(top = 16.dp, start = 7.dp, end = 7.dp)
                .clip(RoundedCornerShape(10.dp))
                .zIndex(2f)
        ) {

            TextField(
                value = editedText,
                onValueChange = { editedText = it },
                label = { Text("Edit Task") }, //
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .zIndex(2f)
            )

            Button(
                onClick = { onConfirm() },
                modifier = Modifier
                    .offset(x = 50.dp, y = 190.dp)
                    .width(180.dp)
                    .height(63.dp)
                    .padding(8.dp)
                    .zIndex(2f)
                ,
            ) {
                Text(
                    text = "Confirm",
                    fontSize = 20.sp
                )
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .offset(x = 50.dp, y = 210.dp)
                    .width(180.dp)
                    .height(63.dp)
                    .padding(8.dp)
                    .zIndex(2f)
                ,
            ) {
                Text(
                    text = "Cancel",
                    fontSize = 20.sp
                )
            }

        }
    }
}