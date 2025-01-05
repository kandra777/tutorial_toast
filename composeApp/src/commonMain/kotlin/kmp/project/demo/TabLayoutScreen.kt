package kmp.project.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmp.project.ui_kit.design.LocalAppColors
import kmp.project.ui_kit.ui.NNHorizontalDivider
import kmp.project.ui_kit.ui.NNTabLayout

@Composable
fun TabLayoutScreen(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize().background(LocalAppColors.current.bg_defaul)) {
        NNTabLayout(tapNames = listOf("切换", "切换"))
        NNHorizontalDivider(thickness = 10.dp)
        NNTabLayout(tapNames = listOf("切换", "切换", "切换"))
        NNHorizontalDivider(thickness = 10.dp)

        NNTabLayout(tapNames = listOf("切换", "切换", "切换", "切换"))
        NNHorizontalDivider(thickness = 10.dp)

        NNTabLayout(tapNames = listOf("切换1", "切换2", "切换3", "切换4", "切换5","切换6","切换7"))
    }
}