package com.chmelik.cmp_workshop

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListView(
    viewModel: BookViewModel,
    listItemView: @Composable (book: Book, onTap: () -> Unit, modifier: Modifier) -> Unit,
    modifier: Modifier
) {
    var presentedBook by rememberSaveable { mutableStateOf<Book?>(null) }
    val sheetState: SheetState = rememberModalBottomSheetState()

    LaunchedEffect(Unit) {
        viewModel.fetchBooks()
    }

    LazyColumn(modifier = modifier) {
        items(items = viewModel.books, key = { it.id }) { book ->
            listItemView(
                book,
                { presentedBook = book },
                Modifier.height(50.dp).fillMaxWidth()
            )
        }
    }

    presentedBook?.let {
        ModalBottomSheet(
            onDismissRequest = { presentedBook = null },
            sheetState = sheetState
        ) {
            BookDetailView(
                book = it,
                viewModel = viewModel
            )
        }
    }
}
