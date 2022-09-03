package com.mariosplen.myapplication.navigation

enum class MyAppScreens {
	HomeScreen,
	QuizScreen;

	companion object {
		fun fromRoute(route: String?): MyAppScreens = when (route?.substringBefore("/")) {
			HomeScreen.name -> HomeScreen
			QuizScreen.name -> QuizScreen
			null -> HomeScreen
			else -> throw IllegalArgumentException("Route $route is not recognized")
		}
	}

}