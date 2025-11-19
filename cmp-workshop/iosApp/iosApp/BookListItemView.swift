//
// Created by Dominik Chmelík on 18.11.2025.
//

import SwiftUI
import ComposeApp

struct BookListItemView: View {
    let book: Book
    let onTap: () -> Void
    var body: some View {
        Button {
            onTap()
        } label: {
            HStack {
                Image(systemName: "book")
                Text(book.name)
                    .font(.headline)
                    .frame(maxWidth: .infinity, alignment: .leading)
            }
            .foregroundStyle(.orange)
            .padding(.horizontal, 16)
        }
    }
}