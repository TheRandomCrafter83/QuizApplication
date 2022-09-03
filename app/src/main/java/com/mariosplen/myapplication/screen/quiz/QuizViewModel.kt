package com.mariosplen.myapplication.screen.quiz

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mariosplen.myapplication.model.Answer
import com.mariosplen.myapplication.model.Question
import com.mariosplen.myapplication.repository.MyAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
	private val myAppRepository: MyAppRepository
) : ViewModel() {


	var questions = emptyFlow<List<Question>>()
	var answers = emptyFlow<List<Answer>>()

	val questionIndex = mutableStateOf(0)

	init {
		getQuestions("MATH")
		getAnswersFromId(0)
	}


	fun getQuestions(category: String) {
		viewModelScope.launch { questions = myAppRepository.getQuestions(category) }
	}


	fun getAnswersFromId(id: Int) {
		viewModelScope.launch { answers = myAppRepository.getAnswersFromId(id) }
	}


}