package com.hoonsa.yanolya.clone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Pink700,
    primaryVariant = Pink900,
    onPrimary = Color.White,
    secondary = Blue700,
    secondaryVariant = Blue100,
    background = Black800
)

private val LightColorPalette = lightColors(
    primary = Pink700,
    primaryVariant = Pink900,
    onPrimary = Color.White,
    secondary = Blue700,
    secondaryVariant = Blue100,
    background = Color.White
)

@Composable
fun YanolyaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}