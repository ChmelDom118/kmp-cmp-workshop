import SwiftUI
import ComposeApp

struct MainView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> some UIViewController {
        return MainViewControllerKt.mainViewController(
            listItemView: { book, onTap in
                return UIHostingController(
                    rootView: BookListItemView(book: book, onTap: { onTap() })
                )
            }
        )
    }

    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        // Not needed.
    }
}

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            MainView()
        }
    }
}
