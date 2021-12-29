package com.example.lab4.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.lab4.R
import com.example.lab4.ui.navigation.Args
import com.example.lab4.ui.navigation.Routes
import com.example.lab4.ui.navigation.navigateTo

@Composable
fun StartScreen(
    navController: NavController
) {
    val selectFileLauncher = rememberLauncherForActivityResult(
        contract = SelectFileContract(),
        onResult = { uri ->
            uri?.let {
                navController.navigateTo(
                    Routes.VIDEO_PLAYER_SCREEN,
                    mapOf(Args.FILE_URI to it)
                )
            }
        }
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { selectFileLauncher.launch(Unit) }) {
            Text(text = stringResource(R.string.select_file_button))
        }
    }
}