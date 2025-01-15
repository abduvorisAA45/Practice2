package com.example.colorpicker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteItem(
    id: Int,
    data: Color,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .clip(RoundedCornerShape(5.dp))
            .border(
                width = 1.dp,
                color = Color(0, 0, 0, 50),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(horizontal = 7.5.dp)
    ) {
        Box(
            modifier = Modifier
                .size(45.dp, 30.dp)
                .background(data)
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            onClick = onEdit
        ) {
            Icon(
                imageVector = Icons.Rounded.Edit,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(7.dp, 5.dp)
                    .size(25.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        CustomButton(
            onClick = onDelete
        ) {
            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(7.dp, 5.dp)
                    .size(25.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FavoriteItemPreview() {
    FavoriteItem(
        -1,
        Color.Red,
        onEdit = {},
        onDelete = {}
    )
}