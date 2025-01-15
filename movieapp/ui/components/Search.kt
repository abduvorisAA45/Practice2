package com.example.movieapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.movieapp.R
import com.example.movieapp.SearchView


@Composable
fun SearchBar(
    data: List<Map<String, Any>>, // ....
    viewModel : SearchView // ....
) {
//    var searchText by remember { mutableStateOf("") } ......

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(Color(100, 80, 80, 180))
        ,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = viewModel.text, // searchText
                onValueChange = { viewModel.text = it },  // { searchText = it }
                modifier = Modifier
                    .height(60.dp)
                    .width(302.7.dp),
                textStyle = TextStyle(
                    fontSize = 23.sp,
                    color = Color(196, 162, 162, 180)
                ),
                placeholder = {
                    Text(
                        text = "Search",
                        fontSize = 23.sp,
                        modifier = Modifier.padding(top = 1.5.dp),
                        color = Color(100, 80, 80, 180)
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(54, 44, 44, 180)
                )
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(60.dp)
                        .width(90.dp),
//                shape = ButtonDefaults.filledTonalShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null,
                        modifier = Modifier.size(35.dp),
                    )
                }

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_filter_list),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}

@Preview(device = "spec:width=392.7dp,height=850.9dp,dpi=440")
@Composable
fun SearchPreview(){
    SearchBar(emptyList(), viewModel = SearchView())
}