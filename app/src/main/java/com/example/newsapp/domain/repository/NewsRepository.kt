package com.example.newsapp.domain.repository

import com.example.newsapp.data.web.response.NewsResponse
import org.intellij.lang.annotations.Language
import retrofit2.Response

interface NewsRepository {
    suspend fun getNews(
        language: String,
        text: String?,
        country: String?,
                        ):Response<NewsResponse>
}