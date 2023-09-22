package com.example.lab01cm.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lab01cm.R
import com.example.lab01cm.ui.theme.component.ComponentButton1
import com.example.lab01cm.ui.theme.component.ComponentDatePicker
import com.example.lab01cm.ui.theme.component.ComponentGenderSelection
import com.example.lab01cm.ui.theme.component.ComponentInput
import com.example.lab01cm.ui.theme.component.ComponentSpinner


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDataBar(
    currentScreen: ScreenContact,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = stringResource(R.string.Back_button)
                    )
                }
            }
        }
    )

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInput(navController: NavHostController) {


    Scaffold(
        topBar = {
            ContactDataBar(
                currentScreen = ScreenContact.Start,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        }
    ) {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavHostController) {
    var selectedGender by remember { mutableStateOf("") }

    val screenOrientation = LocalConfiguration.current.orientation

    val columnModifier = Modifier
        .fillMaxSize()
        .padding(16.dp)

    LazyColumn(
        modifier = columnModifier
    ) {
        item {
            Text(
                text = stringResource(R.string.informacion_personal),
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(10.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 5.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 24.dp else 48.dp)
                )
                var name by remember { mutableStateOf("") }
                ComponentInput(
                    value = name,
                    onValueChange = { name = it },
                    label = stringResource(R.string.nombre)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 5.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 24.dp else 48.dp)
                )
                var lastName by remember { mutableStateOf("") }
                ComponentInput(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = stringResource(R.string.apellido)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(
                    text = stringResource(R.string.genero),
                    fontSize = if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 16.sp else 24.sp
                )
                ComponentGenderSelection(
                    selectedGender = selectedGender,
                    onGenderSelected = { gender -> selectedGender = gender }
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.EditCalendar,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 24.dp else 48.dp)
                )
                Text(
                    text = stringResource(R.string.fecha_de_nacimiento),
                    fontSize = if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 16.sp else 24.sp
                )
            }
        }

        item {
            ComponentDatePicker()
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .size(if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 24.dp else 48.dp)
                )

                Text(
                    text = stringResource(R.string.grado_de_escolaridad),
                    fontSize = if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) 16.sp else 24.sp
                )
            }
        }

        item {
            ComponentSpinner()
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.fillMaxWidth()
            ) {
                ComponentButton1(navController)

            }
        }
    }
}

data class PersonalData(
    val name: String,
    val lastName: String,
    val gender: String,
    val birthDate: String,
    val educationLevel: String
)

enum class ScreenContact(@StringRes val title: Int) {
    Start(title = R.string.informacion_personal),
    Contact(title = R.string.informacion_contacto)
}