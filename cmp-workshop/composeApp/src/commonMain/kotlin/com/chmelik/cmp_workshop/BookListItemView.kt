package com.chmelik.cmp_workshop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BookListItemView(
    book: Book,
    onTap: () -> Unit,
    modifier: Modifier
) {
    Text(
        text = book.name,
        fontWeight = FontWeight.Black,
        modifier = modifier
            .clickable { onTap() }
            .padding(16.dp)
    )
}
