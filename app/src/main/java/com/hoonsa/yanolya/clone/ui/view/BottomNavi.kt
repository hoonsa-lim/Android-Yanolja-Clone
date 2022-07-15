package com.hoonsa.yanolya.clone.ui.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hoonsa.yanolya.clone.R

enum class BottomNaviItemUiState(
    @DrawableRes
    val icon: Int,
    @StringRes
    val label: Int,
    val routeName: String,

    var isNew: Boolean = false,
    var onClick: ((item: BottomNaviItemUiState) -> Unit) = {}
) {
    Home(R.drawable.ic_tap_bottom_home, R.string.bottom_navi_home, "home"),
    Area(R.drawable.ic_tap_bottom_area, R.string.bottom_navi_area, "area"),
    Around(R.drawable.ic_tap_bottom_around, R.string.bottom_navi_around, "around"),
    WishList(R.drawable.ic_tap_bottom_wishlist, R.string.bottom_navi_wish_list, "wish_list"),
    My(R.drawable.ic_tap_bottom_my, R.string.bottom_navi_my, "my"),
}