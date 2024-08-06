package com.example.newsapp.data.web.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.newsapp.data.web.model.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("Select *From news")

    fun getNews() : Flow<List<News>>

    @Insert

    suspend fun addNews(news: News)

    @Delete

    suspend fun deleteNews(news: News)
}