package com.example.todolist

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


data class TaskData(
    var editingTaskId: Int = -1,
    var thisText: String = "",
    var isDoneBtn: Boolean = false,
)

data class BaseData(

    var id: Int = 0,
    var row: Int = 1,
    var col: Int = 1,

    var inProgressTasks: MutableList<TaskData> = mutableListOf(),
    var completedTasks: MutableList<TaskData> = mutableListOf(),
    var sortingButtonsList: Map<String, Boolean> = mapOf(
        "All" to true,
        "Completed" to false,
        "In Progress" to false
    ),

    var textToAdd: String = "",


)