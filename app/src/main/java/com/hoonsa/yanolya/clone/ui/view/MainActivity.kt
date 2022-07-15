package com.hoonsa.yanolya.clone.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hoonsa.yanolya.clone.R
import com.hoonsa.yanolya.clone.ui.theme.*
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
}

@Composable
fun MainView() {
    val navController = rememberNavController()

    YanolyaTheme {
        Scaffold(
            bottomBar = { YanolyaBottomNavigation(navController) }
        ) {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomeScreen(navController) }
                composable("area") { AreaScreen(navController) }
                composable("around") { AroundScreen(navController) }
                composable("wish_list") { WishListScreen(navController) }
                composable("my") { MyScreen(navController) }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column() {
        Button(onClick = {
            Timber.d("click")
        }) {
            Text(text = "HomeScreen")
        }
    }
}

@Composable
fun AreaScreen(navController: NavController) {
    Column() {
        Button(onClick = {
            Timber.d("click")
        }) {
            Text(text = "AreaScreen")
        }
    }
}

@Composable
fun AroundScreen(navController: NavController) {
    Column() {
        Button(onClick = {
            Timber.d("click")
        }) {
            Text(text = "AroundScreen")
        }
    }
}

@Composable
fun WishListScreen(navController: NavController) {
    Column() {
        Button(onClick = {
            Timber.d("click")
        }) {
            Text(text = "WishListScreen")
        }
    }
}

@Composable
fun MyScreen(navController: NavController) {
    Column() {
        Button(onClick = {
            Timber.d("click")
        }) {
            Text(text = "MyScreen")
        }
    }
}

@Composable
fun YanolyaBottomNavigation(navController: NavController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val items = listOf(
        BottomNaviItemUiState.Home.apply {
            onClick = {
                testLogDestinations(currentDestination)
                navController.navigate(this.routeName){

                }
            }
        },
        BottomNaviItemUiState.Area.apply {
            onClick = {
                testLogDestinations(currentDestination)
                navController.navigate(this.routeName){
                    popUpTo("home")
                }
            }
        },
        BottomNaviItemUiState.Around.apply {
            isNew = true
            onClick = {
                testLogDestinations(currentDestination)
                navController.navigate(this.routeName){
                    popUpTo("home") { inclusive = true }
                }
            }
        },
        BottomNaviItemUiState.WishList.apply {
            onClick = {
                testLogDestinations(currentDestination)
                navController.navigate(this.routeName)
            }
        },
        BottomNaviItemUiState.My.apply {
            onClick = {
                testLogDestinations(currentDestination)
                navController.navigate(this.routeName){
                    launchSingleTop = true
                }
            }
        },
    )

    return Row(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .height(Sizes.bottomNaviHeight)
            .padding(horizontal = Sizes.padding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items.forEachIndexed { index, item -> BottomNaviItem(item, currentDestination) }
    }
}

fun testLogDestinations(currentDestination: NavDestination?) {
    Timber.d("destination displayName == ${currentDestination?.displayName}")
    Timber.d("destination route == ${currentDestination?.route}")
    Timber.d("destination label == ${currentDestination?.label}")
    Timber.d("destination id == ${currentDestination?.id}")
    Timber.d("destination navigatorName == ${currentDestination?.navigatorName}")
    Timber.d("destination hierarchy count == ${currentDestination?.hierarchy?.count()}")
    currentDestination?.hierarchy?.forEach {
        Timber.d("destination hierarchy forEach route == ${it.route}")
    }
}

@Composable
fun BottomNaviItem(item: BottomNaviItemUiState, navDestination: NavDestination?) {
    val label = stringResource(id = item.label)
    val isSelect = navDestination?.hierarchy?.any { it.route == item.routeName } == true
    val labelColor = if (isSelect) Black800 else Gray700

    return Column(
        Modifier
            .clickable(indication = null, interactionSource = MutableInteractionSource()){
                item.onClick.invoke(item)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            Icon(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(height = 30.dp, width = 39.dp),
                painter = painterResource(item.icon),
                contentDescription = label,
                tint = if (isSelect) MaterialTheme.colors.primary else labelColor
            )
            NewBadge(Modifier.align(Alignment.TopEnd), item.isNew,)
        }
        Text(label, maxLines = 1, style = MaterialTheme.typography.overline.copy(color = labelColor, letterSpacing = 0.sp))
    }
}

@Composable
fun NewBadge(modifier: Modifier, isNew: Boolean) {
    if (isNew){
        Icon(
            modifier = modifier.size(16.dp),
            painter = painterResource(id = R.drawable.ic_ico_bottom_tap_new),
            contentDescription = stringResource(id = R.string.new_value),
            tint = Pink100
        )
    }
}

@Composable
fun ScreenContainer() {
    Text(text = "screen container")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainView()
}