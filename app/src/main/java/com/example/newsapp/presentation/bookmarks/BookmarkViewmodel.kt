package com.example.newsapp.presentation.bookmarks
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.web.DataBase.NewsDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewmodel @Inject constructor(database: NewsDatabase):ViewModel() {

    private val newsDao=database.newsDao()

    fun getBookmarks()=newsDao.getNews()

    }


