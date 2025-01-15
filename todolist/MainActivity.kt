package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App7()
        }
    }
}



@Composable
fun App7() {

    var base = remember { /*mutableStateOf(*/BaseData()/*)*/ }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Cyan),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = base/*.value*/.textToAdd,
                onValueChange = { content -> base.textToAdd = content }
            )
            Button(
                onClick = {
                    if ( base.textToAdd.isNotBlank() ) {
                        base.inProgressTasks += TaskData()
                        base.textToAdd = ""
                        base.id += 1
                    }
                },
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(5.dp, Color.Black)
                ,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    containerColor = Color.Red,
                    contentColor = Color.Green,
                    disabledContentColor = Color.Yellow,
                    disabledContainerColor = Color.Gray
                ),
            ) {
                Text(text = "Add")
            }
        }

        Row(
            modifier = Modifier
                .offset(0.dp, 120.dp)
                .height(90.dp)
                .fillMaxWidth()
                .background(Color.Yellow),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically

        ) {}
        Column(
            Modifier.offset(0.dp, 240.dp)
                .fillMaxWidth()
                .height(600.dp)
                .background(Color.LightGray)
                .padding(start = 10.dp, top = 20.dp, bottom = 20.dp)
        ) {
            LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(3)) {
                items(base.inProgressTasks) {
                    (taskId, text, isNotDeleted) ->


                    if ( isNotDeleted ) {
                        Task(
                            textContent = text,
                            thisId = taskId,
                            x = ((base.col - 1) * 140).dp,
                            y = ((base.row - 1) * 220).dp,

                            onDelete = { thisID: Int ->
                                base.inProgressTasks = (base.inProgressTasks.map { taskData ->
                                    val (id, content, _) = taskData

                                    if ( id == thisID )
                                        taskData.copy(
                                            editingTaskId = id,
                                            thisText = content,
                                            isDoneBtn = false
                                        )
                                    else
                                        taskData
                                }).toMutableList()
                            },
//                            data =
                        )
                    }
                }
                if ( base.col % 3 == 0 ) {
                    base.col = 1
                    base.row += 1
                } else
                    base.col += 1
            }
        }
//        }
    }
    }
//    }




@Preview(showBackground = true, device = "spec:width=426.7dp,height=952dp,dpi=480")
@Composable
fun GreetingPreview() = App7()