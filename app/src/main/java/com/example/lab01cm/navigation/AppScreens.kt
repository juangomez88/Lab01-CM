package com.example.lab01cm.navigation

sealed class AppScreens(val route: String) {
    object PersonalDataActivity: AppScreens("personal_data")
    object ContactDataActivity: AppScreens("contact_data")
}