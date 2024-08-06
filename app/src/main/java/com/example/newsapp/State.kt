package com.example.newsapp

sealed class State<out T> {
    object Loading : State<Nothing>()
    class Error(val error: String):State<Nothing>()
    class Success<T>(val data:T) : State<T>()
    companion object {
    }

}