package com.example.uitest.navigation

import com.example.uitest.R


sealed class Screen(
    val route: String,
    val title: String,
    var icon: Int,
) {
    object Home : Screen(
        route = "home_screen",
        title = "Home",
        icon = R.drawable.home_icon
    )

    object Send : Screen(
        route = "send_screen",
        title = "Send",
        icon = R.drawable.send
    )
    object History : Screen(
        route = "history_screen",
        title = "History",
        icon = R.drawable.history
    )
    object Scheduled : Screen(
        route = "scheduled_screen",
        title = "Scheduled",
        icon = R.drawable.calendar_icon
    )
}
