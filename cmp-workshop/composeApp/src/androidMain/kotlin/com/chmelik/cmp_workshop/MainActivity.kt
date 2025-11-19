package com.chmelik.cmp_workshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App(
                storage = Storage(LocalContext.current),
                listItemView = { book, onTap, modifier ->
                    BookListItemView(
                        book = book,
                        onTap = onTap,
                        modifier = modifier
                    )
                }
            )
        }
    }
}
