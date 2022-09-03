package com.mariosplen.myapplication.screen.quiz

sealed class QuizEvent{
    data class GetQuestions(val category:String):QuizEvent()
    data class GetAnswers(val questionId:Int):QuizEvent()
}
