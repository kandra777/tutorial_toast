package kmp.project.ui_kit.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults.IconSpacing
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.*
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import androidx.compose.ui.util.fastMaxBy
import kmp.project.ui_kit.design.LocalAppColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NNSingleChoiceSegmentedButton(
    seg1Name: String,
    seg2Name: String,
    defaultIndex: Int = 0,
    modifier: Modifier = Modifier
) {
    var selectedIndex by remember { mutableStateOf(defaultIndex) }
    val options = listOf(seg1Name, seg2Name)
    NNSingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, s ->
            NNSegmentedButton(
                selected = index == selectedIndex,
                onClick = { selectedIndex = index },
                label = {
                    Text(
                        maxLines = 1,
                        text = s,
                        modifier=Modifier.fillMaxWidth()
                    )
                },
                icon = {},
                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                border = BorderStroke(
                    if (selectedIndex == index) 1.dp else 0.dp,
                    LocalAppColors.current.btn_main_default
                ),
                colors = SegmentedButtonDefaults.colors()
                    .copy(
                        activeContainerColor = LocalAppColors.current.btn_main_default,
                        activeContentColor = LocalAppColors.current.txt_white,
                        inactiveContentColor = LocalAppColors.current.txt_brand

                    )
            )
        }
    }
}


@Composable
fun NNSingleChoiceSegmentedButtonRow(
    modifier: Modifier = Modifier,
    space: Dp = SegmentedButtonDefaults.BorderWidth,
    content: @Composable NNSingleChoiceSegmentedButtonRowScope.() -> Unit
) {
    Row(
        modifier =
            modifier
                .selectableGroup()
//                .defaultMinSize(minHeight = 32.dp)
                .height(32.dp)
                .width(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(-space),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val scope = remember { NNSingleChoiceSegmentedButtonScopeWrapper(this) }
        scope.content()
    }
}

@Composable
fun NNSingleChoiceSegmentedButtonRowScope.NNSegmentedButton(
    selected: Boolean,
    onClick: () -> Unit,
    shape: Shape,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: SegmentedButtonColors = SegmentedButtonDefaults.colors(),
    border: BorderStroke =
        SegmentedButtonDefaults.borderStroke(colors.borderColor(enabled, selected)),
    interactionSource: MutableInteractionSource? = null,
    icon: @Composable () -> Unit = { SegmentedButtonDefaults.Icon(selected) },
    label: @Composable () -> Unit,
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val containerColor = colors.containerColor(enabled, selected)
    val contentColor = colors.contentColor(enabled, selected)
    val interactionCount = interactionSource.interactionCountAsState()

    Surface(
        modifier =
            modifier
                .weight(1f)
                .fillMaxHeight()
                .interactionZIndex(selected, interactionCount)
                .semantics { role = Role.RadioButton },
        selected = selected,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        border = border,
        interactionSource = interactionSource
    ) {
        NNSegmentedButtonContent(icon, label)
    }
}

interface NNSingleChoiceSegmentedButtonRowScope : RowScope


@Composable
private fun NNSegmentedButtonContent(
    icon: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
//        val typography = OutlinedSegmentedButtonTokens.LabelTextFont.value
        ProvideTextStyle(
            TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                textAlign = TextAlign.Center,
            )
        ) {
            val scope = rememberCoroutineScope()
            val measurePolicy = remember { NNSegmentedButtonContentMeasurePolicy(scope) }

            Layout(
                modifier = Modifier.height(IntrinsicSize.Min),
                contents = listOf(icon, content),
                measurePolicy = measurePolicy
            )
        }
    }
}


internal class NNSegmentedButtonContentMeasurePolicy(val scope: CoroutineScope) :
    MultiContentMeasurePolicy {
    var animatable: Animatable<Int, AnimationVector1D>? = null
    private var initialOffset: Int? = null

    override fun MeasureScope.measure(
        measurables: List<List<Measurable>>,
        constraints: Constraints
    ): MeasureResult {
        val (iconMeasurables, contentMeasurables) = measurables
        val iconPlaceables = iconMeasurables.fastMap { it.measure(constraints) }
        val iconWidth = iconPlaceables.fastMaxBy { it.width }?.width ?: 0
        val contentPlaceables = contentMeasurables.fastMap { it.measure(constraints) }
        val contentWidth = contentPlaceables.fastMaxBy { it.width }?.width
        val height = contentPlaceables.fastMaxBy { it.height }?.height ?: 0
        val width =
            maxOf(SegmentedButtonDefaults.IconSize.roundToPx(), iconWidth) +
                    IconSpacing.roundToPx() +
                    (contentWidth ?: 0)
        val offsetX =
            if (iconWidth == 0) {
                -(SegmentedButtonDefaults.IconSize.roundToPx() + IconSpacing.roundToPx()) / 2
            } else {
                0
            }

        if (initialOffset == null) {
            initialOffset = offsetX
        } else {
            val anim =
                animatable
                    ?: Animatable(initialOffset!!, Int.VectorConverter).also { animatable = it }
            if (anim.targetValue != offsetX) {
                scope.launch {
                    anim.animateTo(offsetX, tween(350))
                }
            }
        }

        return layout(width, height) {
            iconPlaceables.fastForEach { it.place(0, (height - it.height) / 2) }

            val contentOffsetX =
                SegmentedButtonDefaults.IconSize.roundToPx() +
                        IconSpacing.roundToPx() +
                        (animatable?.value ?: offsetX)

            contentPlaceables.fastForEach { it.place(contentOffsetX, (height - it.height) / 2) }
        }
    }
}


@Stable
internal fun SegmentedButtonColors.containerColor(enabled: Boolean, active: Boolean): Color {
    return when {
        enabled && active -> activeContainerColor
        enabled && !active -> inactiveContainerColor
        !enabled && active -> disabledActiveContainerColor
        else -> disabledInactiveContainerColor
    }
}

@Stable
internal fun SegmentedButtonColors.contentColor(enabled: Boolean, checked: Boolean): Color {
    return when {
        enabled && checked -> activeContentColor
        enabled && !checked -> inactiveContentColor
        !enabled && checked -> disabledActiveContentColor
        else -> disabledInactiveContentColor
    }
}


@Stable
internal fun SegmentedButtonColors.borderColor(enabled: Boolean, active: Boolean): Color {
    return when {
        enabled && active -> activeBorderColor
        enabled && !active -> inactiveBorderColor
        !enabled && active -> disabledActiveBorderColor
        else -> disabledInactiveBorderColor
    }
}

private const val NNCheckedZIndexFactor = 5f

private fun Modifier.interactionZIndex(checked: Boolean, interactionCount: State<Int>) =
    this.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.width, placeable.height) {
            val zIndex = interactionCount.value + if (checked) NNCheckedZIndexFactor else 0f
            placeable.place(0, 0, zIndex)
        }
    }


@Composable
private fun InteractionSource.interactionCountAsState(): State<Int> {
    val interactionCount = remember { mutableIntStateOf(0) }
    LaunchedEffect(this) {
        this@interactionCountAsState.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press,
                is FocusInteraction.Focus -> {
                    interactionCount.intValue++
                }

                is PressInteraction.Release,
                is FocusInteraction.Unfocus,
                is PressInteraction.Cancel -> {
                    interactionCount.intValue--
                }
            }
        }
    }

    return interactionCount
}


class NNSingleChoiceSegmentedButtonScopeWrapper(scope: RowScope) :
    NNSingleChoiceSegmentedButtonRowScope, RowScope by scope

@Preview
@Composable
fun NNSegmentedButtonPreview() {
    NNSingleChoiceSegmentedButton("标题1", "标题2")
}

