package com.example.test.network

import com.example.test.network.BooksApi
import com.example.test.network.SafeApiRequest

class BooksRepository(private val api: BooksApi) : SafeApiRequest(){//api instance

    suspend fun getBooks() = apiRequest { api.getBooks() }
}