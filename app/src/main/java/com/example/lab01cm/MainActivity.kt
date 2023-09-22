package com.example.lab01cm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lab01cm.navigation.AppNavigation

import com.example.lab01cm.ui.theme.Lab01CMTheme
import com.example.lab01cm.screens.UserInput


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab01CMTheme {
                AppNavigation()
            }
        }
    }
}



