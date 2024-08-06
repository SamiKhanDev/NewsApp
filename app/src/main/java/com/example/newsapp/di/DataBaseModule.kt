package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.data.web.DataBase.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Context):NewsDatabase{
        return NewsDatabase.getDatabase(context)
    }
}