//
// Created by Dominik Chmelík on 15.10.2025.
//

import SwiftUI
import Observation
import ComposeApp

struct BookItem: Identifiable {
    private let book: Book

    init(book: Book) {
        self.book = book
    }

    var id: String {
        return book.id
    }

    var name: String {
        return book.name
    }

    var rating: Double {
        return book.rating
    }

    var pageCount: Int {
        return Int(book.pageCount)
    }
}

@MainActor
@Observable
final class BookViewModel {
    @ObservationIgnored
    private let bookService: BookService = BookService(storage: Storage())

    private(set) var books: [BookItem] = []
    private var likedIDs: Set<String> = []

    func fetchBooks() {
        books = bookService.fetchBooks().map { BookItem(book: $0) }
        likedIDs = Set(books.filter { bookService.isBookLiked(id: $0.id) }.map { $0.id })
    }

    func isBookLiked(id: String) -> Bool {
        return likedIDs.contains(id)
    }

    func likeUnlikeBook(id: String) {
        if likedIDs.contains(id) {
            bookService.unlikeBook(id: id)
            likedIDs.remove(id)
        } else {
            bookService.likeBook(id: id)
            likedIDs.insert(id)
        }
    }
}
