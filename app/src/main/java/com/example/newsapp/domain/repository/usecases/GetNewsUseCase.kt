package com.example.newsapp.domain.repository.usecases

import com.example.newsapp.data.web.response.NewsResponse
import  com.example.newsapp.domain.repository.NewsRepository;

import javax.inject.Inject;

public class GetNewsUseCase @Inject constructor (
    private val newsRepository:NewsRepository
)
{
    suspend operator fun invoke(
        language:String,
        country:String?,
        text:String?,

    ):NewsResponse {
        val response = newsRepository.getNews(language, text, country)
        if(response.body()==null){
            if (response.code()==404)
            throw Exception("No news found")
            else if (response.code()==500)
                throw Exception("Server error")
            else if (response.code()==401)
                throw Exception("Unauthorized")
            else if (response.code()==400)
                throw Exception("bad request")

        }
        return newsRepository.getNews(language, text, country).body()!!
    }

}