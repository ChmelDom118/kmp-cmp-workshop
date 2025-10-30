//
// Created by Dominik Chmelík on 15.10.2025.
//

import SwiftUI
import Observation

@MainActor
@Observable
final class BookViewModel {
    @ObservationIgnored
    private let bookService: BookService = BookService()

    private(set) var books: [Book] = []
    private var likedIDs: Set<String> = []

    func fetchBooks() {
        books = bookService.fetchBooks()
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
