package com.example.newsapp.di
import android.content.Context
import com.example.newsapp.NewsApp
import com.example.newsapp.data.web.Newsapi
import com.example.newsapp.utils.Base_url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context): NewsApp{
        return context as NewsApp

    }
    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context{
        return context

    }
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .client(client)
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(30L,java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(30L,java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }
    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit):Newsapi{
        return retrofit.create(Newsapi::class.java)

    }
}