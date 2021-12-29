package com.example.lab4.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab4.ui.screens.StartScreen
import com.example.lab4.ui.screens.PlayerScreen

object Routes {
    const val START_SCREEN = "start screen"
    const val VIDEO_PLAYER_SCREEN = "video player screen"
}

object Args {
    const val FILE_URI = "uri"
}

@Composable
fun NavController(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.START_SCREEN
    ) {
        composable(Routes.START_SCREEN) {
            StartScreen(navController)
        }

        composable(Routes.VIDEO_PLAYER_SCREEN) {
            PlayerScreen(
                navController = navController,
                fileUri = it[Args.FILE_URI]
            )
        }
    }
}

fun NavController.navigateTo(route: String, args: Map<String, Any>) {
    navigate(route)
    backQueue.last().putArguments(args)
}

fun NavBackStackEntry.putArguments(args: Map<String, Any>) =
    args.forEach { (key, value) -> savedStateHandle.set(key, value) }

inline operator fun <reified T> NavBackStackEntry.get(key: String) =
    savedStateHandle.get<T>(key)!!
