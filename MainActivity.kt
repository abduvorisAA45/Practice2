package com.example.krestikiinolikisnovigarsiyey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}


// Classes and Objects
class GameBoardStatementData : ViewModel() {
    var data = mutableListOf<MutableState<List<Boolean?>>>(
        mutableStateOf(listOf(null, null, null)),
        mutableStateOf(listOf(null, null, null)),
        mutableStateOf(listOf(null, null, null))
    )
}


sealed class GameResult(isGameEndBy: Boolean)
data object X : GameResult(isGameEndBy = true)
data object O : GameResult(isGameEndBy = false)


// Variables
var gameBordStatement by mutableStateOf(GameBoardStatementData())

var counterX by mutableIntStateOf(0)
var counterO by mutableIntStateOf(0)
var counterDraw by mutableIntStateOf(0)

var isXorO by mutableStateOf(false)
var isContinue by mutableStateOf(false)



// Methods
fun onClearBoard() {
    gameBordStatement = GameBoardStatementData()
}

fun isWon(resultCheck: GameResult) : Boolean {

    val isTypeCheck = when( resultCheck ) {
        is O -> false
        is X -> true
    }
    if(     gameBordStatement.data[0].value[0] == isTypeCheck &&
            gameBordStatement.data[0].value[1] == isTypeCheck &&
            gameBordStatement.data[0].value[2] == isTypeCheck ||

            gameBordStatement.data[1].value[0] == isTypeCheck &&
            gameBordStatement.data[1].value[1] == isTypeCheck &&
            gameBordStatement.data[1].value[2] == isTypeCheck ||

            gameBordStatement.data[2].value[0] == isTypeCheck &&
            gameBordStatement.data[2].value[1] == isTypeCheck &&
            gameBordStatement.data[2].value[2] == isTypeCheck ||

            gameBordStatement.data[0].value[0] == isTypeCheck &&
            gameBordStatement.data[1].value[0] == isTypeCheck &&
            gameBordStatement.data[2].value[0] == isTypeCheck ||

            gameBordStatement.data[0].value[1] == isTypeCheck &&
            gameBordStatement.data[1].value[1] == isTypeCheck &&
            gameBordStatement.data[2].value[1] == isTypeCheck ||

            gameBordStatement.data[0].value[2] == isTypeCheck &&
            gameBordStatement.data[1].value[2] == isTypeCheck &&
            gameBordStatement.data[2].value[2] == isTypeCheck ||

            gameBordStatement.data[0].value[0] == isTypeCheck &&
            gameBordStatement.data[1].value[1] == isTypeCheck &&
            gameBordStatement.data[2].value[2] == isTypeCheck ||

            gameBordStatement.data[0].value[2] == isTypeCheck &&
            gameBordStatement.data[1].value[1] == isTypeCheck &&
            gameBordStatement.data[2].value[0] == isTypeCheck
    ) {
        isXorO = false
        return true
    }
    return false
}

fun isDraw() : Boolean {

    if(     gameBordStatement.data[0].value[0] != null &&
            gameBordStatement.data[0].value[1] != null &&
            gameBordStatement.data[0].value[2] != null &&

            gameBordStatement.data[1].value[0] != null &&
            gameBordStatement.data[1].value[1] != null &&
            gameBordStatement.data[1].value[2] != null &&

            gameBordStatement.data[2].value[0] != null &&
            gameBordStatement.data[2].value[1] != null &&
            gameBordStatement.data[2].value[2] != null
    ) {
        isXorO = false
        return true
    }
    return false
}

fun onBoardClick(column: Int, row: Int) {
    if ( gameBordStatement.data[column].value[row] != null )
        return

        isXorO = !isXorO
        gameBordStatement.data[column].value =
            if ( row == 0 )
                listOf(isXorO) + gameBordStatement.data[column].value.slice(1..2)
            
            else if ( row == 1 )
                gameBordStatement.data[column].value.slice(0..<1) +
                listOf(isXorO) +
                gameBordStatement.data[column].value.slice(2..<3)
            else
                gameBordStatement.data[column].value.slice(0..1) + listOf(isXorO)
}

fun isEndGame(onFinalPageNavigate: () -> Unit){
    if ( isWon(X) ) {
        counterX += 1
        onFinalPageNavigate()
    } else if ( isWon(O) ) {
        counterO += 1
        onFinalPageNavigate()
    } else if ( isDraw() ) {
        counterDraw += 1
        onClearBoard()
        onFinalPageNavigate()
    }
}

//// Composables
//@Serializable
//object MainScreen
////object GameScreen
//object FinalScreen

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "mainPage"
    ) {
        composable(route = "mainPage") {
            MainPage(onNavigate = { navController.navigate(route = "gamePage") })
        }
        composable(route = "gamePage") {
            GamePage(
                onFinalPageNavigate = { navController.navigate(route = "finalPage") },
                onMainPageNavigate = { navController.navigate(route = "mainPage") }
            )
        }
        composable(route = "finalPage") {
            FinalPage(
                onPlayAgainNavigate = { navController.navigate("gamePage") },
                onMenuNavigate = {
                    navController
                        .popBackStack(
                            route = "mainPage",
                            inclusive = false,
                            saveState = false
                        )
                },
                onGameContinueNavigate = {
                    navController
                        .popBackStack(
                            route = "gamePage",
                            inclusive = false,
                            saveState = true
                        )
                }
            )
        }
    }

}

@Composable
fun MainPage(
    onNavigate: () -> Unit
) {

val background by remember { mutableStateOf(Color(47, 41, 41, 255)) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)

        ,

        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(330.dp)
                .height(700.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(background)
            ,

            contentAlignment = Alignment.Center
        ) {
            Column {
                if( isContinue ) {
                    Button(
                        onClick = onNavigate,
                        modifier = Modifier
                            .width(200.dp)
                            .height(55.dp),
                        colors = ButtonColors(
                            containerColor = Color(84, 46, 30, 255),
                            contentColor = Color(241, 120, 90, 255),
                            disabledContainerColor = Color(152, 130, 130, 255),
                            disabledContentColor = Color.Red
                        )
                    ) {
                        Text(
                            text = "Continue",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W900
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }

                Button(
                    onClick = {
                        onNavigate()
                        counterX = 0
                        counterO = 0
                        counterDraw = 0
                        onClearBoard()
                        isContinue = true
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(55.dp)
                    ,
                    colors = ButtonColors(
                        containerColor = Color(84, 46, 30, 255),
                        contentColor = Color(241, 120, 90, 255),
                        disabledContainerColor = Color(152, 130, 130, 255),
                        disabledContentColor = Color.Red
                    )
                ) {
                    Text(
                        text = "Start New Game",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W900
                    )
                }
            }
        }
    }
}


@Composable
fun GamePage(
    onFinalPageNavigate: () -> Unit,
    onMainPageNavigate: () -> Unit
){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(199, 160, 160, 255))
        ,
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .height(80.dp)
                .width(200.dp)
                .align(Alignment.TopCenter)
                .background(Color(241, 143, 81, 255))
            ,
        ){
            Row {
                listOf(
                    Icons.Sharp.ArrowBack to { onMainPageNavigate() },
                    Icons.Sharp.ArrowForward to { onFinalPageNavigate() }
                ).forEach {
                    pair ->
                    val (icon, func) = pair

                    Button(
                        onClick = func,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            }
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(3),
            modifier = Modifier
                .width(300.dp)
                .height(295.dp)
                .background(Color.Gray)
                .padding(9.dp)
            ,
        ) {
            items(count = 3) { column ->
                Column {
                    repeat(times = 3) { row ->
                        val textXorO =
                            when ( gameBordStatement.data[column].value[row] ) {
                                true -> "X"
                                false -> "O"
                                else -> ""
                        }


                        Box(
                            modifier = Modifier
                                .size(90.dp)
                                .background(Color.Black)
                            ,
                        ) {
                            Text(
                                text = textXorO,
                                color = Color.White,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 7.dp)
                                    .clickable {
                                        onBoardClick(column, row)
                                        isEndGame { onFinalPageNavigate() }
                                    }
                                ,
                                fontSize = TextUnit(value = 70f, type = TextUnitType.Sp),
                                fontWeight = FontWeight.W500,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun FinalPage(
    onPlayAgainNavigate: () -> Unit,
    onMenuNavigate: () -> Unit,
    onGameContinueNavigate: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(210, 182, 171, 255))
        ,

        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .width(300.dp)
                .height(650.dp)
                .background(Color(86, 84, 84, 255))
                .border(5.dp, Color.Black)
                .padding(10.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(152, 149, 149, 255))
                    .padding(25.dp)
                ,

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf(counterX to "X", counterO to "O", counterDraw to "Draw")
                    .forEach { pair ->
                    val (name, counter) = pair

                    Text(
                        text = "$name: $counter",
                        fontSize = 40.sp
                    )
                }
            }

            Spacer(Modifier.height(40.dp))

            Column(verticalArrangement = spacedBy(15.dp)) {

                listOf(
                    "Continue" to { onGameContinueNavigate() },
                    "Play Again" to { onPlayAgainNavigate(); onClearBoard() },
                    "Menu" to { onMenuNavigate() }
                ).forEach {
                    pair ->
                    val (name, func) = pair
                    Button(
                        onClick = func,
                        modifier = Modifier
                            .width(180.dp)
                            .height(70.dp)
                            .clip(shape = RoundedCornerShape(25.dp))
                            .border(3.dp, Color.Black, shape = RoundedCornerShape(25.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(114, 111, 111, 255)
                        )
                    ) {
                        Text(
                            text = name,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, device = "spec:width=392.7dp,height=850.9dp,dpi=440")
@Composable
fun GreetingPreview() {
    App()
}