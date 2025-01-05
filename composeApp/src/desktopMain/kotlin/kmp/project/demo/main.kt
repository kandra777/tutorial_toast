package kmp.project.demo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kmp.project.demo.db.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPDemo",
    ) {
        App()
    }
}