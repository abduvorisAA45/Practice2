package com.example.todolist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Task(
    textContent: String = "",
    thisId: Int = -1,
    x: Dp = 0.dp,
    y: Dp = 0.dp,
    onDelete: (Int) -> Unit = {},
    data: TaskData
) {


    Box(
        modifier = Modifier
            .offset(x = x, y = y)
            .width(120.dp)
            .height(200.dp)
            .background(
                if ( data.isDoneBtn )
                    Color.Green
                else
                    Color.Yellow
            )
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
    ) {
        Text(text = data.thisText)

        Button(
            onClick = { onDelete(thisId) },
            modifier = Modifier
                .width(50.dp)
                .height(30.dp)
                .offset(x = 0.dp, y = 110.dp)
            ,
            shape = RoundedCornerShape(5.dp),
            colors = ButtonColors(
                containerColor = Color.Red,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.Gray
            ),
            contentPadding = PaddingValues(0.dp)
        ) { Text(text = "Delete", fontSize = 12.sp) }

        Button(
            onClick = { data.editingTaskId = thisId },
            modifier = Modifier
                .size(30.dp)
                .offset(x = 65.dp, y = 110.dp)
            ,
            shape = RoundedCornerShape(5.dp),
            colors = ButtonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.Gray
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "Edit", fontSize = 12.sp)
        }

        Button(
            onClick = { data.isDoneBtn = !data.isDoneBtn },
            modifier = Modifier
                .width(100.dp)
                .height(33.dp)
                .offset(y = 150.dp)
            ,
            colors = ButtonColors(
                containerColor = Color.Blue,
                contentColor = Color.Gray,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.Gray
            )
        ) {
            Text(
                text = if ( data.isDoneBtn )
                    "Undone"
                else
                    "Done",
                fontWeight = FontWeight.W800,
                fontSize = 13.sp
            )
        }
    }
}

