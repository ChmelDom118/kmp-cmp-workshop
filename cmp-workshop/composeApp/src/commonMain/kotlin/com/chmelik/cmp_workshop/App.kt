package com.chmelik.cmp_workshop

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    storage: Storage,
    listItemView: @Composable (book: Book, onTap: () -> Unit, modifier: Modifier) -> Unit
) {
    MaterialTheme {
        val viewModel = remember { BookViewModel(storage = storage) }
        BookListView(
            viewModel = viewModel,
            listItemView = listItemView
        )
    }
}
