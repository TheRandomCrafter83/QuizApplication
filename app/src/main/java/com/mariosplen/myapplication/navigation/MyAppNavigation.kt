package com.mariosplen.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mariosplen.myapplication.screen.home.HomeScreen
import com.mariosplen.myapplication.screen.quiz.QuizScreen

@Composable
fun MyAppNavigation() {
	val navController = rememberNavController()
	val navHost = NavHost(
		navController = navController,
		startDestination = MyAppScreens.HomeScreen.name
	) {
		composable(route = MyAppScreens.HomeScreen.name) {
			HomeScreen(navController = navController)
		}

		composable(
			route = MyAppScreens.QuizScreen.name + "/{category}",
			arguments = listOf(navArgument(name = "category") { type = NavType.StringType })
		) { backStackEntry ->


			QuizScreen(
				category = backStackEntry.arguments?.getString("category")
			)
		}
	}
}