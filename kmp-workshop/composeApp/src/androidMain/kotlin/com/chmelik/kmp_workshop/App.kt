package com.chmelik.kmp_workshop

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val context = LocalContext.current
        val viewModel = remember { BookViewModel(context = context) }
        BookListView(
            viewModel = viewModel
        )
    }
}
