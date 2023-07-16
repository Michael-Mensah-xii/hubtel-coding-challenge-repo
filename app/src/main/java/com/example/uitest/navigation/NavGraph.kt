package com.example.uitest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uitest.screens.HistoryScreen
import com.example.uitest.screens.Home
import com.example.uitest.screens.Schedule
import com.example.uitest.screens.Send

@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.History.route
    ){
        composable(route = Screen.Home.route){
            Home()
        }

        composable(route = Screen.Send.route){
            Send()
        }

        composable(route = Screen.History.route){
           HistoryScreen()
        }

        composable(route = Screen.Scheduled.route){
            Schedule()
        }
    }

}