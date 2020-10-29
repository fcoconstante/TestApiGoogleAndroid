package com.example.test.model

data class BookGoogleResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<Book>
)