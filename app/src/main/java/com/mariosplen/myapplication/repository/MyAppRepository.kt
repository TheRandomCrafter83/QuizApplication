package com.mariosplen.myapplication.repository

import com.mariosplen.myapplication.data.MyAppDao
import javax.inject.Inject


class MyAppRepository @Inject constructor(
	private val driverTestDao: MyAppDao
) {

	fun getQuestions(category: String) = driverTestDao.getQuestions(category)


	fun getAnswersFromId(id: Int) = driverTestDao.getAnswersFromId(id)


}