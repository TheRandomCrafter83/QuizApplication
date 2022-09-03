package com.mariosplen.myapplication.screen.quiz

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mariosplen.myapplication.repository.MyAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
	private val myAppRepository: MyAppRepository,
) : ViewModel() {

	private val _state = mutableStateOf(QuizState())
	val state : State<QuizState> = _state

	private var questionsJob: Job? = null
	private var answersJob: Job? = null

	val questionIndex = mutableStateOf(0)

	init {
		getQuestions("MATH")
		getAnswersFromId(0)
	}


	fun onEvent(event: QuizEvent){
		when(event){
			is QuizEvent.GetQuestions->{
				getQuestions(event.category)
			}
			is QuizEvent.GetAnswers->{
				getAnswersFromId(event.questionId)
			}
		}
	}

	private fun getQuestions(category:String) {
		questionsJob?.cancel()
		questionsJob = myAppRepository.getQuestions(category)
			.onEach {questions->
				_state.value = state.value.copy(
					questions = questions
				)
			}
			.launchIn(viewModelScope)
	}


	private fun getAnswersFromId(id: Int) {
		answersJob?.cancel()
		answersJob = myAppRepository.getAnswersFromId(id)
			.onEach { answers->
				_state.value = state.value.copy(
					answers = answers
				)
			}
			.launchIn(viewModelScope)
	}


}