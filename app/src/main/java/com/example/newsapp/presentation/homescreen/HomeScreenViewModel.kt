package com.example.newsapp.presentation.homescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.State
import com.example.newsapp.data.web.model.News
import com.example.newsapp.data.web.response.NewsResponse
import com.example.newsapp.domain.repository.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {
    private val _state = MutableStateFlow<State<NewsResponse>>(State.Loading)
    val state= _state as StateFlow<State<NewsResponse>>
    private var job:Job?=null
    init {


             getNews()


    }
      fun getNews(text:String?=null,country:String?=null){
          job?.cancel()
         job= viewModelScope.launch{
              _state.tryEmit(State.Loading)
              try {
                  val result= getNewsUseCase.invoke("sp", text, country)
                  _state.tryEmit(State.Success(result))
              }catch (e:Exception){
                  _state.tryEmit(State.Error(e.message.toString()))
              }
          }



    }
}