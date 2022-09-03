package com.mariosplen.myapplication.di

import android.content.Context
import androidx.room.Room
import com.mariosplen.myapplication.data.MyAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


	@Singleton
	@Provides
	fun provideDatabase(
		@ApplicationContext context: Context
	) = Room.databaseBuilder(
		context,
		MyAppDatabase::class.java,
		"questionsdatabase.db"
	).createFromAsset("database/questionsdatabase.db")
		.build()


	@Singleton
	@Provides
	fun provideDao(database: MyAppDatabase) = database.MyAppDao()


}