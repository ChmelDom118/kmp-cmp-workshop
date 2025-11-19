package com.chmelik.kmp_workshop

class BookService(
    private val storage: Storage
) {
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
        return storage.getBool("book-liked-$id")
    }

    fun likeBook(id: String) {
        storage.setBool(true, "book-liked-$id")
    }

    fun unlikeBook(id: String) {
        storage.setBool(false, "book-liked-$id")
    }
}
