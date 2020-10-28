package com.example.test

import retrofit2.Retrofit

interface BooksApi {
    companion object{
        operator fun invoke(): BooksApi{  //method that will execute when we hit this Interface
            Retrofit.Builder()
                .addConverterFactory("")
        }
    }
}