package com.example.newsapp.domain.repository

import com.example.newsapp.data.web.Newsapi
import com.example.newsapp.data.web.response.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(val api:Newsapi):NewsRepository {
    override suspend fun getNews(language: String, text: String?, country: String?): Response<NewsResponse> {
        val response = api.getNews(country,language,text)
        return response

    }
}