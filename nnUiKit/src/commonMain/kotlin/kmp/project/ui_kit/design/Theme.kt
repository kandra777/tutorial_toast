package kmp.project.ui_kit.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

interface AppColor {
    val bg_defaul: Color
    val bg_white: Color
    val bg_IM: Color

    val bg_white_default: Color

    val border_default: Color

    val btn_main_default: Color
    val btn_black_default: Color

    val icon_primary: Color

    val txt_title: Color
    val txt_secondary: Color
    val txt_brand: Color
    val txt_primary: Color
    val txt_disabled: Color
    val txt_tertiary: Color
    val txt_golden: Color
    val txt_white: Color

    val grey_tag_default: Color
}

data object LightColor : AppColor {
    override val bg_defaul: Color
        get() = utral_2
    override val bg_white: Color
        get() = utral_0
    override val bg_IM: Color
        get() = utral_2
    override val bg_white_default: Color
        get() = utral_0
    override val border_default: Color
        get() = utral_2
    override val btn_main_default: Color
        get() = brand_5
    override val btn_black_default: Color
        get() = utral_10
    override val icon_primary: Color
        get() = utral_9
    override val txt_title: Color
        get() = utral_11
    override val txt_secondary: Color
        get() = utral_7
    override val txt_brand: Color
        get() = brand_5
    override val txt_primary: Color
        get() = utral_9
    override val txt_disabled: Color
        get() = utral_3
    override val txt_tertiary: Color
        get() = utral_5
    override val txt_golden: Color
        get() = golden_4
    override val txt_white: Color
        get() = utral_0
    override val grey_tag_default: Color
        get() = utral_3
}

data object DarkColor : AppColor {
    override val bg_defaul: Color
        get() = utral_10
    override val bg_white: Color
        get() = utral_9
    override val bg_IM: Color
        get() = utral_10
    override val bg_white_default: Color
        get() = utral_9
    override val border_default: Color
        get() = utral_10
    override val btn_main_default: Color
        get() = brand_6
    override val btn_black_default: Color
        get() = utral_8
    override val icon_primary: Color
        get() = utral_3
    override val txt_title: Color
        get() = utral_1
    override val txt_secondary: Color
        get() = utral_5
    override val txt_brand: Color
        get() = brand_6
    override val txt_primary: Color
        get() = utral_3
    override val txt_disabled: Color
        get() = utral_9
    override val txt_tertiary: Color
        get() = utral_7
    override val txt_golden: Color
        get() = golden_5
    override val txt_white: Color
        get() = utral_2
    override val grey_tag_default: Color
        get() = utral_9
}

val LocalAppColors = staticCompositionLocalOf<AppColor> { LightColor }


@Composable
fun NNTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val color = if (darkTheme) DarkColor else LightColor

    // Composition locals
    CompositionLocalProvider(
        LocalAppColors provides color,
    ) {
        MaterialTheme(
            content = content,
        )
    }

}

