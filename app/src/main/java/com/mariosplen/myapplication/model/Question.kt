package com.mariosplen.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question(
	@PrimaryKey(autoGenerate = true)
	val id: Int,
	val category: String,
	val question: String,
)