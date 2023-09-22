package com.example.lab01cm.ui.theme.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab01cm.R
import com.example.lab01cm.navigation.AppScreens

@Composable
fun ComponentButton1(navController: NavController) {
    Box(
        contentAlignment = androidx.compose.ui.Alignment.BottomEnd,
        modifier = Modifier.fillMaxWidth()
    ) {

        Button(
            onClick = {
                      navController.navigate(route = AppScreens.ContactDataActivity.route)
            },
            modifier = Modifier
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text(text = stringResource(R.string.siguiente))
        }
    }
}