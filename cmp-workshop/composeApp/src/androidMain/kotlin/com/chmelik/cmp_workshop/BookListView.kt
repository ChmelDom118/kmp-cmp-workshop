package com.chmelik.cmp_workshop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListView(
    viewModel: BookViewModel
) {
    var presentedBook by rememberSaveable { mutableStateOf<Book?>(null) }
    val sheetState: SheetState = rememberModalBottomSheetState()

    LaunchedEffect(Unit) {
        viewModel.fetchBooks()
    }

    LazyColumn {
        items(items = viewModel.books, key = { it.id }) { book ->
            Text(
                text = book.name,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .clickable { presentedBook = book }
                    .padding(16.dp)
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
