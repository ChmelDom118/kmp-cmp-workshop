//
// Created by Dominik Chmelík on 14.10.2025.
//

import SwiftUI

struct BookListView: View {
    @State private var viewModel: BookViewModel = BookViewModel()
    @State private var presentedBook: Book?

    var body: some View {
        List(viewModel.books, id: \.id) { book in
            Text(book.name)
                .fontWeight(.heavy)
                .onTapGesture {
                    presentedBook = book
                }
        }
        .task {
            viewModel.fetchBooks()
        }
        .sheet(item: $presentedBook) { book in
            BookDetailView(viewModel: $viewModel, book: book)
        }
    }
}
