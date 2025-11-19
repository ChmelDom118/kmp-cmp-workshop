//
// Created by Dominik Chmelík on 15.10.2025.
//

import SwiftUI

struct BookDetailView: View {
    @Binding var viewModel: BookViewModel
    let book: BookItem

    var body: some View {
        VStack(spacing: 10) {
            Text(book.name)
                .fontWeight(.heavy)
                .padding(.bottom, 10)
            Text("\(book.pageCount) pages")
            Text("Rating \(book.rating)/5")
            Button {
                viewModel.likeUnlikeBook(id: book.id)
            } label: {
                let isLiked = viewModel.isBookLiked(id: book.id)
                Image(systemName: isLiked ? "heart.fill" : "heart")
                    .tint(isLiked ? .red : .gray)
            }
        }
    }
}
