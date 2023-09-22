package com.example.lab01cm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab01cm.screens.ContactDataActivity
import com.example.lab01cm.screens.UserInput

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.PersonalDataActivity.route ) {
        composable(route = AppScreens.PersonalDataActivity.route){
            UserInput(navController)
        }
        composable(route = AppScreens.ContactDataActivity.route){
            ContactDataActivity(navController)
        }
    }
}