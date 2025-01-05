package kmp.project.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kmp.project.demo.navigation.NNNavHost
import kmp.project.ui_kit.design.LocalAppColors

@Composable
fun NNApp(appState: AppState) {
    NNApp(appState = appState, modifier = Modifier)
}

@Composable
internal fun NNApp(appState: AppState, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize().background(LocalAppColors.current.bg_defaul)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        NNNavHost(appState)

    }
}

