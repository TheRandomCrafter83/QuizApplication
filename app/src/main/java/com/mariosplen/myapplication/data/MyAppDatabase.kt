package com.mariosplen.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mariosplen.myapplication.model.Answer
import com.mariosplen.myapplication.model.Question

@Database(entities = [Question::class, Answer::class], version = 4, exportSchema = false)
abstract class MyAppDatabase : RoomDatabase() {
	abstract fun MyAppDao(): MyAppDao
}