package kmp.project.ui_kit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp.project.ui_kit.design.LocalAppColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NNTabLayout(defaultIndex: Int = 0, tapNames: List<String>, modifier: Modifier = Modifier) {
    var seletedIndex by remember { mutableStateOf(defaultIndex) }
    if (tapNames.size < 5) {
        PrimaryTabRow(
            selectedTabIndex = seletedIndex,
            modifier = Modifier.height(40.dp).fillMaxWidth().background(LocalAppColors.current.bg_white_default)
                .padding(top = 10.dp),
            containerColor = LocalAppColors.current.bg_white_default,
            indicator = @Composable {
                Spacer(
                    modifier
                        .tabIndicatorOffset(seletedIndex)
                        .requiredHeight(3.dp)
                        .requiredWidth(16.dp)
                        .background(color = LocalAppColors.current.txt_brand, shape = RectangleShape)

                )
            },
            divider = {}
        ) {
            tapNames.forEachIndexed { index, s ->
                Tab(
                    selected = index == seletedIndex,
                    modifier = Modifier.padding(bottom = 9.dp).defaultMinSize(minWidth = 55.dp),
                    onClick = {
                        seletedIndex = index
                    }) {
                    Text(
                        s, style =
                            if (seletedIndex == index) {
                                TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(600),
                                    color = LocalAppColors.current.txt_brand,
                                    textAlign = TextAlign.Center,
                                )
                            } else {
                                TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(400),
                                    color = LocalAppColors.current.txt_primary,
                                    textAlign = TextAlign.Center,
                                )
                            },
                        lineHeight = 20.sp
                    )
                }
            }
        }

    } else {
        PrimaryScrollableTabRow(
            selectedTabIndex = seletedIndex,
            modifier = Modifier.height(40.dp).fillMaxWidth().background(LocalAppColors.current.bg_white_default)
                .padding(top = 10.dp),
            containerColor = LocalAppColors.current.bg_white_default,
            edgePadding = 0.dp,
            indicator = @Composable {
                Spacer(
                    modifier
                        .tabIndicatorOffset(seletedIndex)
                        .requiredHeight(3.dp)
                        .requiredWidth(16.dp)
                        .background(color = LocalAppColors.current.txt_brand, shape = RectangleShape)

                )
            },
            divider = {}
        ) {
            tapNames.forEachIndexed { index, s ->
                Tab(
                    selected = index == seletedIndex,
                    modifier = Modifier.padding(bottom = 9.dp).defaultMinSize(minWidth = 55.dp),
                    onClick = {
                        seletedIndex = index
                    }) {
                    Text(
                        s, style =
                            if (seletedIndex == index) {
                                TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(600),
                                    color = LocalAppColors.current.txt_brand,
                                    textAlign = TextAlign.Center,
                                )
                            } else {
                                TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(400),
                                    color = LocalAppColors.current.txt_primary,
                                    textAlign = TextAlign.Center,
                                )
                            },
                        lineHeight = 20.sp
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun NNTabLayoutPrevicw() {
    NNTabLayout(tapNames = listOf("切换1", "切换2"))
}

