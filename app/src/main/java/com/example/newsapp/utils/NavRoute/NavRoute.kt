package com.example.newsapp.utils.NavRoute

import android.util.Base64
import com.example.newsapp.data.web.model.News
import com.google.gson.Gson
import java.net.URLDecoder
import java.net.URLEncoder

object NavRoute {
    fun createNewsDetailsRoute(news: News, isLocal: Boolean? = false): String {
        val encodedImage = URLEncoder.encode(news.image, "utf-8")
        val encodedUrl = URLEncoder.encode(news.url, "utf-8")
        val tempNews = news.copy(image = encodedImage, url = encodedUrl)
        val gson = encrypt(Gson().toJson(tempNews))
        return "/details/news=$gson&isLocal=$isLocal"
    }

    fun getNewsFromRoute(json: String): News {
        val decrypte = decrypt(json)
        val news = Gson().fromJson(decrypte, News::class.java)
        val decodedImage = URLDecoder.decode(news.image, "utf-8")
        val decodeUrl = URLDecoder.decode(news.url, "utf-8")
        return news.copy(image = decodedImage, url = decodeUrl)
    }

    fun decrypt(test: String): String {
        val replacedString = test.replace("*","/")
        return Base64.decode(replacedString, Base64.NO_WRAP).decodeToString()
    }

    @Throws(Exception::class)
    fun encrypt(value: String): String {
        return Base64.encodeToString(value.toByteArray(), Base64.NO_WRAP).replace("/","*")
    }
}