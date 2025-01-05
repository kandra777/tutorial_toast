package kmp.project.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kmp.project.ui_kit.design.LocalAppColors
import kmp.project.ui_kit.ui.NNHorizontalDivider
import kmp.project.ui_kit.ui.NNSingleChoiceSegmentedButton

@Composable
fun SegmentedButtonScreen(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize().background(LocalAppColors.current.bg_defaul)) {
        NNSingleChoiceSegmentedButton("标题", "标题")
        NNHorizontalDivider(thickness = 20.dp)
        NNSingleChoiceSegmentedButton("长标题1", "长标题2", 1)
    }
}