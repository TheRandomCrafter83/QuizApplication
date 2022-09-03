package com.mariosplen.myapplication.screen.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun QuizScreen(
	category: String?,
	viewModel: QuizViewModel = hiltViewModel(),
) {

	val questions by viewModel.questions.collectAsState(initial = emptyList())
	val answers by viewModel.answers.collectAsState(initial = emptyList())

	var questionIndex by viewModel.questionIndex

	if (questions.isEmpty()) {
		CircularProgressIndicator()
	} else {
		val question = try {
			questions[questionIndex]
		} catch (ex: Exception) {
			null
		}
		if (question != null) {
			Column(
				modifier = Modifier
					.fillMaxSize(),
				verticalArrangement = Arrangement.SpaceEvenly,
				horizontalAlignment = Alignment.CenterHorizontally
			) {

				Text(question.question)

				answers.forEach {
					Text(it.answer)
				}

				Button(
					onClick = {
						questionIndex++
						viewModel.getAnswersFromId(questions[questionIndex].id)
					}) {
					Text("Next")
				}
			}
		}
	}
}