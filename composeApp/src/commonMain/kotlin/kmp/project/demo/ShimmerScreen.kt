package kmp.project.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kmp.project.ui_kit.ui.NNLongShimmer
import kmp.project.ui_kit.ui.NNShortShimmer

@Composable
fun ShimmerScreen(modifier: Modifier = Modifier) {
    NNLongShimmer(true, {})
}

@Composable
fun ShortShimmerScreen(){
    NNShortShimmer(true,{})
}

