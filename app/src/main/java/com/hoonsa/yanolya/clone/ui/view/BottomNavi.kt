package com.hoonsa.yanolya.clone.ui.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hoonsa.yanolya.clone.R

enum class BottomNaviItemUiState(
    @DrawableRes
    val icon: Int,
    @StringRes
    val label: Int,

    var isNew: Boolean = false,
) {
    Home(R.drawable.ic_tap_bottom_home, R.string.bottom_navi_home),
    Area(R.drawable.ic_tap_bottom_area, R.string.bottom_navi_area),
    Around(R.drawable.ic_tap_bottom_around, R.string.bottom_navi_around),
    WishList(R.drawable.ic_tap_bottom_wishlist, R.string.bottom_navi_wish_list),
    My(R.drawable.ic_tap_bottom_my, R.string.bottom_navi_my),
}