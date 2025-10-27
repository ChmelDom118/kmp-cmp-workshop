//
// Created by Dominik Chmelík on 14.10.2025.
//

import Foundation

final class BookService {
    static let instance = BookService()

    func fetchBooks() -> [Book] {
        return [
            Book(id: "1", name: "The Hobbit", pageCount: 300, rating: 4.5),
            Book(id: "2", name: "The Lord of the Rings", pageCount: 500, rating: 4.2),
            Book(id: "3", name: "1984", pageCount: 400, rating: 4.7),
            Book(id: "4", name: "To Kill a Mockingbird", pageCount: 600, rating: 4.5),
            Book(id: "5", name: "The War of the Worlds", pageCount: 700, rating: 3.9),
            Book(id: "6", name: "Pride and Prejudice", pageCount: 800, rating: 4.5),
            Book(id: "7", name: "Moby-Dick", pageCount: 900, rating: 4.3),
            Book(id: "8", name: "The Catcher in the Rye", pageCount: 1000, rating: 4.5),
            Book(id: "9", name: "The Alchemist", pageCount: 1200, rating: 4.5),
            Book(id: "10", name: "The Lord of the Flies", pageCount: 1100, rating: 4.0)
        ]
    }

    func isBookLiked(id: String) -> Bool {
        return UserDefaults.standard.bool(forKey: "book-liked-\(id)")
    }

    func likeBook(id: String) {
        UserDefaults.standard.set(true, forKey: "book-liked-\(id)")
    }

    func unlikeBook(id: String) {
        UserDefaults.standard.set(false, forKey: "book-liked-\(id)")
    }
}
