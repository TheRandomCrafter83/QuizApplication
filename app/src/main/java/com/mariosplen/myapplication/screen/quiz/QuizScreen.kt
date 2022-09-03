package com.mariosplen.myapplication.screen.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mariosplen.myapplication.navigation.MyAppScreens

@Composable
fun QuizScreen(
	navController: NavController,
	category: String,
	viewModel: QuizViewModel = hiltViewModel(),
) {

	val state = viewModel.state.value

	var questionIndex by viewModel.questionIndex

	viewModel.onEvent(
		QuizEvent.GetQuestions(category)
	)

	if (state.questions.isEmpty()) {
		CircularProgressIndicator()
	} else {

		val question = state.questions[questionIndex]
		viewModel.onEvent(QuizEvent.GetAnswers(question.id))

		Column(
			modifier = Modifier
				.fillMaxSize(),
			verticalArrangement = Arrangement.SpaceEvenly,
			horizontalAlignment = Alignment.CenterHorizontally
		) {

			Text(question.question,
					modifier = Modifier.padding(16.dp)
				)

			state.answers.forEach {
				Text(it.answer)
			}

			Button(
				onClick = {
					if (questionIndex >= state.questions.size - 1){
						navController.navigate(MyAppScreens.HomeScreen.name)
						return@Button
					}
					questionIndex++
				}) {
				Text("Next")
			}
		}
	}
}