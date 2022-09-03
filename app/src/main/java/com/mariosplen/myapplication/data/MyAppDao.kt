package com.mariosplen.myapplication.data

import androidx.room.Dao
import androidx.room.Query
import com.mariosplen.myapplication.model.Answer
import com.mariosplen.myapplication.model.Question
import kotlinx.coroutines.flow.Flow

@Dao
interface MyAppDao {


	@Query("SELECT * FROM questions WHERE category = :category")
	fun getQuestions(
		category: String,
	): Flow<List<Question>>


	@Query("SELECT * FROM answers WHERE q_id = :id ORDER BY RANDOM()")
	fun getAnswersFromId(
		id: Int
	): Flow<List<Answer>>


}