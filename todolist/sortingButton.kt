import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun SortingButton(
    name: String = "",
    inputButtonList: MutableMap<String, Boolean> = mutableMapOf(),
    onClick: () -> Unit = {},
) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .sizeIn(minWidth = 80.dp, minHeight = 60.dp)
        ,
        colors = ButtonColors(
            containerColor =
            if( inputButtonList[name] == true )
                Color.DarkGray
            else
                Color.Gray,

            contentColor = Color.Green,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.LightGray
        )
    ) {
        Text(
            text = name,
            fontSize = 23.sp,
            fontWeight = FontWeight.W800
        )
    }
}