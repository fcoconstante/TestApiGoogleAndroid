package com.example.test.model

data class Book(
    val kind: String,
    val id: String,
    val volumeInfo: InfoBook,
)

data class InfoBook(
    val title: String,
    val subtitle: String,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
    val like_percent: Int,
    val description: String,
    val pageCount: Int,
    val imageLinks: Thumbnail
)

data class Thumbnail(
    val smallThumbnail: String,
    val thumbnail: String
)