package com.example.composeapp.mainPage

import androidx.compose.ui.graphics.painter.Painter

data class NavigationItem(
    val title: String,
    val selectedIcon: Painter,
    val unSelectedIcon: Painter,
    val route: String
)