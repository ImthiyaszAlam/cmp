package com.imthiyas.kaamai.ui.navigation

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object Report : Screen("report", "Report")
}
