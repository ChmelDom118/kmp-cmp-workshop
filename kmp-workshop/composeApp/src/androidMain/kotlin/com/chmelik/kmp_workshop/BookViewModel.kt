package com.chmelik.kmp_workshop

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BookViewModel(context: Context) : ViewModel() {
    private val bookService = BookService(context)

    class Factory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return BookViewModel(context.applicationContext) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    var books by mutableStateOf(listOf<Book>())
        private set

    var likedIDs by mutableStateOf(setOf<String>())
        private set

    fun fetchBooks() {
        books = bookService.fetchBooks()
        likedIDs = books
            .filter { bookService.isBookLiked(it.id) }
            .map { it.id }
            .toSet()
    }

    fun isBookLiked(id: String): Boolean {
        return likedIDs.contains(id)
    }

    fun likeUnlikeBook(id: String) {
        if (likedIDs.contains(id)) {
            bookService.unlikeBook(id)
            likedIDs = likedIDs - id
        } else {
            bookService.likeBook(id)
            likedIDs = likedIDs + id
        }
    }
}
