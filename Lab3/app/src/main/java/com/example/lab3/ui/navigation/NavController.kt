package com.example.lab3.ui.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab3.ui.*

@ExperimentalMaterialApi
@Composable
fun NavController(
    navController: NavHostController,
    dataScreenViewModel: DataScreenViewModel,
    inputScreenViewModel: InputScreenViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Input
    ) {
        composable(route = Routes.Input) {
            InputScreen(navController = navController, viewModel = inputScreenViewModel)
        }

        composable(route = Routes.Result) {
            ResultScreen(navController = navController, viewModel = inputScreenViewModel)
        }

        composable(route = Routes.Data) {
            DataScreen(navController = navController, viewModel = dataScreenViewModel)
        }
    }
}