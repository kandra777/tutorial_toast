package kmp.project.demo

import androidx.compose.ui.window.ComposeUIViewController
import kmp.project.demo.db.initKoin

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}