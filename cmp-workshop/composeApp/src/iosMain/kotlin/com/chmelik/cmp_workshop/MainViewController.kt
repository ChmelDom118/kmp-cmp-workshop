package com.chmelik.cmp_workshop

import androidx.compose.ui.viewinterop.UIKitViewController
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

@Suppress("unused")
fun mainViewController(
    listItemView: (book: Book, onTap: () -> Unit) -> UIViewController
): UIViewController = ComposeUIViewController {
    App(
        storage = Storage(),
        listItemView = { book, onTap, modifier ->
            UIKitViewController(
                factory = { listItemView(book, onTap) },
                modifier = modifier
            )
        }
    )
}
