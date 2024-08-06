package com.example.newsapp.data.web

import com.example.newsapp.data.web.response.NewsResponse
import com.example.newsapp.utils.Api_key
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Newsapi {
    @GET("search-news")
    suspend fun getNews(
       @Query("country")country:String?,
       @Query("language")language:String,
       @Query("text")text:String?,
       @Query("news-sources")newsSources:String?="https://www.bbc.co.uk",
       @Query("api-key") apikey:String= Api_key
    ): Response<NewsResponse>



}