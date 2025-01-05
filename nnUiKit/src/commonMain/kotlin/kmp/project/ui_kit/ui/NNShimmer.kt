package kmp.project.ui_kit.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kmp.project.ui_kit.design.LocalAppColors
import kmp.project.ui_kit.design.green_0
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NNLongShimmer(isLoading: Boolean, contentAfterLoading: @Composable () -> Unit, modifier: Modifier = Modifier) {
    if (isLoading) {
        Column(
            modifier = modifier.fillMaxWidth().height(630.dp)
                .padding(top = 12.dp, bottom = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            ShimmerType1()
            ShimmerType2()
            ShimmerType3()
            ShimmerType4()
        }

    } else {
        contentAfterLoading.invoke()
    }
}

@Composable
private fun ShimmerType1() {
    Row(
        modifier = Modifier.fillMaxWidth().height(90.dp)
            .padding(start = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
    ) {
        Box(
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(10.dp))
                .shimmerEffect()
        )
        Column(modifier = Modifier.padding(start = 12.dp)) {
            Row() {
                Box(
                    modifier = Modifier.size(139.dp, 22.dp).clip(RoundedCornerShape(2.dp))
                        .shimmerEffect()
                )
                Box(
                    modifier = Modifier.padding(start = 6.dp).size(38.dp, 22.dp).clip(RoundedCornerShape(12.dp))
                        .shimmerEffect()
                )
            }
            Box(
                modifier = Modifier.padding(top = 6.dp).size(278.dp, 62.dp)
                    .clip(RoundedCornerShape(topStart = 2.dp, 8.dp, 8.dp, 8.dp))
                    .shimmerEffect()
            )
        }
        // Child views.
    }

}

@Composable
private fun ShimmerType2() {
    Row(
        modifier = Modifier.fillMaxWidth().height(194.dp)
            .padding(start = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
    ) {
        Box(
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(10.dp))
                .shimmerEffect()
        )
        Column(modifier = Modifier.padding(start = 12.dp)) {
            Row() {
                Box(
                    modifier = Modifier.size(183.dp, 22.dp).clip(RoundedCornerShape(2.dp))
                        .shimmerEffect()
                )
                Box(
                    modifier = Modifier.padding(start = 6.dp).size(38.dp, 22.dp).clip(RoundedCornerShape(12.dp))
                        .shimmerEffect()
                )
            }
            Box(
                modifier = Modifier.padding(top = 6.dp).size(230.dp, 40.dp)
                    .clip(RoundedCornerShape(topStart = 2.dp, 8.dp, 8.dp, 8.dp))
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier.padding(top = 6.dp).size(166.dp, 120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect()
            )
        }

    }

}

@Composable
private fun ShortShimmerType2() {
    Row(
        modifier = Modifier.fillMaxWidth().height(194.dp)
            .padding(start = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
    ) {
        Box(
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(10.dp))
                .shimmerEffect()
        )
        Column(modifier = Modifier.padding(start = 12.dp)) {
            Row() {
                Box(
                    modifier = Modifier.size(183.dp, 22.dp).clip(RoundedCornerShape(2.dp))
                        .shimmerEffect()
                )
                Box(
                    modifier = Modifier.padding(start = 6.dp).size(38.dp, 22.dp).clip(RoundedCornerShape(12.dp))
                        .shimmerEffect()
                )
            }
            Box(
                modifier = Modifier.padding(top = 6.dp).size(230.dp, 40.dp)
                    .clip(RoundedCornerShape(topStart = 2.dp, 8.dp, 8.dp, 8.dp))
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier.padding(top = 6.dp).size(98.dp, 96.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect()
            )
        }

    }

}

@Composable
private fun ShimmerType3() {
    Row(
        modifier = Modifier.fillMaxWidth().height(114.dp)
            .padding(start = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
    ) {
        Box(
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(10.dp))
                .shimmerEffect()
        )
        Column(modifier = Modifier.padding(start = 12.dp)) {
            Row() {
                Box(
                    modifier = Modifier.size(83.dp, 22.dp).clip(RoundedCornerShape(2.dp))
                        .shimmerEffect()
                )
                Box(
                    modifier = Modifier.padding(start = 6.dp).size(38.dp, 22.dp).clip(RoundedCornerShape(12.dp))
                        .shimmerEffect()
                )
            }
            Box(
                modifier = Modifier.padding(top = 6.dp).size(278.dp, 40.dp)
                    .clip(RoundedCornerShape(topStart = 2.dp, 8.dp, 8.dp, 8.dp))
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier.padding(top = 6.dp).size(102.dp, 40.dp)
                    .clip(RoundedCornerShape(topStart = 2.dp, 8.dp, 8.dp, 8.dp))
                    .shimmerEffect()
            )
        }
        // Child views.
    }

}

@Composable
private fun ShimmerType4() {
    Row(
        modifier = Modifier.fillMaxWidth().height(160.dp)
            .padding(start = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.Top,
    ) {
        Box(
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(10.dp))
                .shimmerEffect()
        )
        Column(modifier = Modifier.padding(start = 12.dp)) {
            Row() {
                Box(
                    modifier = Modifier.size(160.dp, 22.dp).clip(RoundedCornerShape(2.dp))
                        .shimmerEffect()
                )
                Box(
                    modifier = Modifier.padding(start = 6.dp).size(38.dp, 22.dp).clip(RoundedCornerShape(12.dp))
                        .shimmerEffect()
                )
            }
            Box(
                modifier = Modifier.padding(top = 6.dp).size(278.dp, 40.dp)
                    .clip(RoundedCornerShape(topStart = 2.dp, 8.dp, 8.dp, 8.dp))
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier.padding(top = 6.dp).size(102.dp, 40.dp)
                    .clip(RoundedCornerShape(topStart = 2.dp, 8.dp, 8.dp, 8.dp))
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier.padding(top = 6.dp).size(223.dp, 40.dp)
                    .clip(RoundedCornerShape(topStart = 2.dp, 8.dp, 8.dp, 8.dp))
                    .shimmerEffect()
            )
        }
        // Child views.
    }

}


@Composable
fun NNShortShimmer(isLoading: Boolean, contentAfterLoading: @Composable () -> Unit, modifier: Modifier = Modifier) {
    if (isLoading) {
        Column(
            modifier = modifier.fillMaxWidth().height(630.dp)
                .padding(top = 12.dp, bottom = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            ShimmerType1()
            ShortShimmerType2()
            ShimmerType3()
        }

    } else {
        contentAfterLoading.invoke()
    }
}

@Preview
@Composable
fun NNLongShimmerPreivew() {
    NNLongShimmer(true, {})
}


fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    val transtion = rememberInfiniteTransition()

    val startOffsetX = transtion.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
//            repeatMode = RepeatMode.Restart
        )
    )
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                LocalAppColors.current.grey_tag_default.copy(alpha = 0.9f),
                LocalAppColors.current.grey_tag_default.copy(alpha = 0.3f),
                LocalAppColors.current.grey_tag_default.copy(alpha = 0.9f),
            ),
            start = androidx.compose.ui.geometry.Offset(x = startOffsetX.value, y = 0f),
            end = androidx.compose.ui.geometry.Offset(
                x = startOffsetX.value + size.width.toFloat(),
                y = size.height.toFloat()
            )
        )
    ).onGloballyPositioned {
        size = it.size
    }
}