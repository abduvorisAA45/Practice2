package com.example.sidenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           App()
        }
    }
}



sealed class PersonalInfoType(var value: MutableState<String>)
data object Name : PersonalInfoType(value = mutableStateOf("Name"))
data object Surname : PersonalInfoType(value = mutableStateOf("Surname"))


var isOpenedMenu by mutableStateOf(false)
var isTextEditing by mutableStateOf(false)
var isDarkMode by mutableStateOf(false)

var personalInfoType: PersonalInfoType? = null




@Serializable
object Home

@Serializable
object Favorite

@Serializable
object Notifications

@Serializable
object Settings


fun colorBy(darkModeOn: Color, darkModeOff: Color) =
    if( isDarkMode ) darkModeOn else darkModeOff






@Composable
fun App() {
    val navController = rememberNavController()
    var innerPadding = PaddingValues(horizontal = 0.dp)

    if( isTextEditing )
        EditTextField()

    Scaffold (
        modifier = Modifier.clickable(enabled = isOpenedMenu) {
            if( isOpenedMenu ) isOpenedMenu = false
        },
        topBar = { MenuLenta() },
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        padding ->
        innerPadding = padding

        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Home> { HomePage() }
            composable<Favorite>{ FavoritePage() }
            composable<Notifications> { NotificationsPage() }
            composable<Settings> { SettingsPage() }
        }
    }

    Menu(navController = navController)

}


@Preview(
    showBackground = true,
    device = "spec:width=392.7dp,height=850.9dp,dpi=440"
)
@Composable
fun AppPreview() {
    App()
}
