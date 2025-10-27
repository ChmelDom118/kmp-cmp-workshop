package com.chmelik.kmp_workshop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BookDetailView(
    book: Book,
    viewModel: BookViewModel
) {
    Column(Modifier.padding(16.dp)) {
        Text(book.name, fontWeight = FontWeight.Bold)
        Text("Pages: ${book.pageCount}")
        Text("Rating: ${book.rating}")
        Button(
            onClick = {
                viewModel.likeUnlikeBook(book.id)
            }
        ) {
            Text(if (viewModel.isBookLiked(book.id)) "Unlike" else "Like")
        }
    }
}
