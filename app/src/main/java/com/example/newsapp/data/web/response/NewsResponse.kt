package com.example.newsapp.data.web.response

import com.example.newsapp.data.web.model.News

data class NewsResponse(
    val available: Int,
    val news: List<News>,
    val number: Int,
    val offset: Int
)