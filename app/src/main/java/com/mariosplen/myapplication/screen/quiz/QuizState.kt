package com.mariosplen.myapplication.screen.quiz

import com.mariosplen.myapplication.model.Answer
import com.mariosplen.myapplication.model.Question

data class QuizState(
    val questions:List<Question> = emptyList(),
    val answers:List<Answer> = emptyList()
)
