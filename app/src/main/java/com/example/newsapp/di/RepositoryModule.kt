package com.example.newsapp.di

import com.example.newsapp.data.web.Newsapi
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideNewsRepository(api:Newsapi):NewsRepository{
        return NewsRepositoryImpl(api)
    }

}