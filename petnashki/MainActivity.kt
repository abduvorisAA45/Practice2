package com.example.petnashki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.text.isDigitsOnly
import com.example.petnashki.ui.theme.PetnashkiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainPetnashki(name = "Petnashki")
        }
    }
}

@Composable
fun MainPetnashki(name: String, modifier: Modifier = Modifier) {

    // Variables

    var inputRowStr by remember { mutableStateOf("0") }
    var inputColStr by remember { mutableStateOf("0") }

    var inputRowNum by remember { mutableIntStateOf(0) }
    var inputColNum by remember { mutableIntStateOf(0) }

    var isNotGreeted by remember { mutableStateOf(true) }
    var isErrorInput by remember { mutableStateOf(false) }
    var isConsoleOn by remember { mutableStateOf(false) }
    var isToSetField by remember { mutableStateOf(false) }


    val correctCells by remember { mutableStateOf(
        mutableListOf<Int?>()
    ) }



    var cells by remember { mutableStateOf(
        mutableListOf(
            mutableListOf<Int?>()
        )
    ) }


//    val consoleList by remember { mutableStateOf(mutableListOf("")) }

    // Methods



//    @Composable
//    fun display() {
//
//        var bigIndex = 0
//
//        correctCells.forEachIndexed { index, elem ->
//            Text(
//                text = consoleList.last(),
//                modifier = Modifier
//                    .offset(0.dp, 30.dp + (10 * ).dp),
//                fontSize = 25.sp,
//                color = Color.Green
//            )
//        }
//    }


//    @Composable
//    fun console(){
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Black)
//            ,
//        ){
//            Text(
//                text = "correct cells",
//                color = Color.Green,
//                fontSize = 20.sp,
//                modifier = Modifier
//                    .offset()
//                ,
//            )
//            display()
//        }
//    }

    fun setCells(){

        correctCells.shuffled().forEachIndexed {
            index, elem ->
            when {
                index / inputRowNum == 0 -> cells += mutableListOf(elem)
                index == 0 -> cells.last() += elem
                else -> cells.last() += elem
            }
        }

        cells = cells.toMutableList()
    }

    // Не работает
    @Composable
    fun setField() {

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .padding(10.dp)
            ,
        ) {
            val width = (370f / inputRowNum.toFloat())
            val height = (370f / inputColNum.toFloat())

            cells.forEachIndexed { rowIndex, row ->
                row.forEachIndexed { colIndex, column ->
                    Box(
                        modifier = Modifier
                            .width(width.dp)
                            .height(height.dp)

                            // Не работает
                            .offset(
                                x = 0.dp,
                                y = 0.dp
                            )
                            .background(Color.Blue)
                        ,
                    ) {

                    }
                }
            }
        }
    }
    
    fun setCorrectCells(){

        var absoluteIndex = 1

        for( rowIndex in 0..<inputRowNum - 1 ){
            correctCells += mutableListOf<Int?>()
            for( colIndex in 0..<inputColNum ){
                correctCells += absoluteIndex
                absoluteIndex += 1
            }
        }

        correctCells[correctCells.lastIndex] = null

    }


    @Composable
    fun GreetingWindow(
        modifier: Modifier = Modifier
    ) {
        Box(
            modifier = modifier,
        ) {
            Text(
                text = "Input a row quantity",
                modifier = Modifier
                    .width(220.dp)
                    .height(50.dp)
                    .offset(60.dp, 20.dp)
                    .background(Color.Red)
                    .padding(top = 10.dp),
                color = Color.White,
                fontSize = 25.sp,
            )

            TextField(
                value = inputRowStr,
                onValueChange = {
                    inputRowStr = it
                    inputRowNum = it.toInt()
                                },
                modifier = Modifier
                    .width(220.dp)
                    .height(60.dp)
                    .offset(60.dp, 80.dp)
                ,
                textStyle = TextStyle.Default,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color.White
                )
            )

            Text(
                text = "Input a column quan-ty",
                modifier = Modifier
                    .width(255.dp)
                    .height(50.dp)
                    .offset(50.dp, 150.dp)
                    .background(Color.Red)
                    .padding(top = 10.dp),
                color = Color.White,
                fontSize = 25.sp,
            )

            TextField(
                value = inputColStr,
                onValueChange = {
                    inputColStr = it
                    inputColNum = it.toInt()
                                },
                modifier = Modifier
                    .width(220.dp)
                    .height(60.dp)
                    .offset(60.dp, 215.dp)
                    .background(Color.White)
                ,
            )

            Button(
                onClick = {
                    if(
                        inputColStr.isDigitsOnly() && inputColStr.toInt() in 2..7 &&
                        inputRowStr.isDigitsOnly() && inputRowStr.toInt() in 2..7
                    ) {
                        isNotGreeted = false
                        setCorrectCells()
                        setCells()
                        isToSetField = true

                    }
                    else
                        isErrorInput = true
                },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .width(125.dp)
                    .height(55.dp)
                    .offset(110.dp, 350.dp)
                    .background(Color.Green) // Находиться под чем-то. Не смог понять как исправить.
                    .zIndex(2f)
                ,
            ){
                Text(
                    text = "Input",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0, 0, 0, 0))
                        .padding(top = 3.dp, start = 7.dp)
                    ,
                    fontSize = 28.sp
                )
            }
        }
    }


    @Composable
    fun ErrorInputWindow(modifier: Modifier = Modifier) {
        Box(modifier = modifier) {
            Text(
                text = "              Error !!!\n\n" +
                        "You entered incorrect number or non-number\n\n" +
                        "Please re-input the input value " +
                        "and enter numbers from 2 to 7",
                fontSize = 25.sp,
                color = Color.White
            )

            Button(
                onClick = { isErrorInput = false },
//                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .width(180.dp)
                    .height(50.dp)
                    .offset(35.dp, 330.dp)
//                    .background(Color.Yellow)
                ,
            ){
                Text(
                    text = "Re-input",
                    fontSize = 25.sp
                )
            }
        }
    }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        ,

        contentAlignment = Alignment.Center
    ) {


//        Button(
//            onClick = {
//                if( isConsoleOn )
//                    isConsoleOn = false
//                else
//                    isConsoleOn = true
//                      },
//            modifier = Modifier
//                .width(120.dp)
//                .height(60.dp)
//                .offset(120.dp, -400.dp)
//                .zIndex(3f)
//            ,
//        ){
//            Text(
//                text = "console",
//                fontSize = 15.sp
//            )
//        }


//        if( isConsoleOn )
//            console()




        if( isNotGreeted ) {
            GreetingWindow(
                modifier = Modifier
                    .width(350.dp)
                    .height(600.dp)
                    .background(Color.Yellow)
                    .border(10.dp, Color.Black)
                    .zIndex(2f),
            )
        }

        if( isErrorInput ){
            ErrorInputWindow(
                modifier = Modifier
                    .width(300.dp)
                    .height(500.dp)
                    .background(Color.Green)
                    .align(Alignment.Center)
                    .border(10.dp, Color.Red)
                    .padding(25.dp)
                    .zIndex(2f)
                ,
            )
        }

        if( isToSetField ){
            setField()
        }



    }




}



@Preview(showBackground = true, device = "spec:width=426.7dp,height=952dp,dpi=480")
@Composable
fun GreetingPreview() {
    MainPetnashki("Android")
}
