package com.hoonsa.yanolya.clone.ui.view

import android.os.Bundle
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    YanolyaTheme {
        Scaffold(
            bottomBar = { YanolyaBottomNavigation() }
        ) {

        }
    }
}

@Composable
fun YanolyaBottomNavigation(){
    val items = listOf(
        BottomNaviItemUiState.Home,
        BottomNaviItemUiState.Area,
        BottomNaviItemUiState.Around,
        BottomNaviItemUiState.WishList.apply { isNew = true },
        BottomNaviItemUiState.My,
    )
    var selectedItem by remember { mutableStateOf(0) }

    return Row(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .height(Sizes.bottomNaviHeight)
            .padding(horizontal = Sizes.padding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        items.forEachIndexed { index, item ->
            BottomNaviItem(item, index, selectedItem)
        }
    }
}

@Composable
fun BottomNaviItem(item: BottomNaviItemUiState, index: Int, selectedItem: Int) {
    val label = stringResource(id = item.label)
    val isSelect = index == selectedItem
    val labelColor = if (isSelect) Black800 else Gray700

    return Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            Icon(
                modifier = Modifier.align(Alignment.Center).size(height = 30.dp, width = 39.dp),
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