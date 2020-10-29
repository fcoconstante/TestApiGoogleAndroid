package com.example.test.network

import com.example.test.model.BookGoogleResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BooksApi {

    @GET("volumes?q=harry")
    suspend fun getBooks(): Response<BookGoogleResponse>

    companion object {
        operator fun invoke(): BooksApi {  //method that will execute when we hit this Interface
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.googleapis.com/books/v1/")
                .build()
                .create(BooksApi::class.java)
        }
    }
}