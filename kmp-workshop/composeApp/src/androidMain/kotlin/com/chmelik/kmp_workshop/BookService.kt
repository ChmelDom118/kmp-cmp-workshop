package com.chmelik.kmp_workshop

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class BookService(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("book_preferences", Context.MODE_PRIVATE)

    fun fetchBooks(): List<Book> = listOf(
        Book("1", "The Hobbit", 300, 4.5),
        Book("2", "The Lord of the Rings", 500, 4.2),
        Book("3", "1984", 400, 4.7),
        Book("4", "To Kill a Mockingbird", 600, 4.5),
        Book("5", "The War of the Worlds", 700, 3.9),
        Book("6", "Pride and Prejudice", 800, 4.5),
        Book("7", "Moby-Dick", 900, 4.3),
        Book("8", "The Catcher in the Rye", 1000, 4.5),
        Book("9", "The Alchemist", 1200, 4.5),
        Book("10", "The Lord of the Flies", 1100, 4.0)
    )

    fun isBookLiked(id: String): Boolean {
        return preferences.getBoolean("book-liked-$id", false)
    }

    fun likeBook(id: String) {
        preferences.edit { putBoolean("book-liked-$id", true) }
    }

    fun unlikeBook(id: String) {
        preferences.edit { putBoolean("book-liked-$id", false) }
    }
}
