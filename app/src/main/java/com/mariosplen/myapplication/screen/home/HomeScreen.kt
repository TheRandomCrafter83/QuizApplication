package com.mariosplen.myapplication.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mariosplen.myapplication.navigation.MyAppScreens

@Composable
fun HomeScreen(navController: NavController) {

	Column(
		modifier = Modifier
			.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceEvenly,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Button(
			onClick = {
				navController.navigate(route = MyAppScreens.QuizScreen.name + "?category=MATH")
			}
		) {
			Text("START MATH QUIZ")
		}


		Button(
			onClick = {
				navController.navigate(route = MyAppScreens.QuizScreen.name + "?category=GEOGRAPHY")
			}
		) {
			Text("START GEOGRAPHY QUIZ")
		}
	}
}