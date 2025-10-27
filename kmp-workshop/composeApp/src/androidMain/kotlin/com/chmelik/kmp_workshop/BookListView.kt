package com.chmelik.kmp_workshop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListView(
    viewModel: BookViewModel = viewModel(
        factory = BookViewModel.Factory(LocalContext.current.applicationContext)
    )
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

    if (presentedBook != null) {
        ModalBottomSheet(
            onDismissRequest = { presentedBook = null },
            sheetState = sheetState
        ) {
            BookDetailView(
                book = presentedBook!!,
                viewModel = viewModel
            )
        }
    }
}
