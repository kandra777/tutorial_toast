package kmp.project.ui_kit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp.project.ui_kit.design.LocalAppColors
import kmpdemo.nnuikit.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ChatInput(initialContent: String = "", isEmoji: Boolean = false, initialOriginalMessage: String = "") {
    val content = rememberTextFieldState(initialContent)
    var originalMessage by remember { mutableStateOf(initialOriginalMessage) }
    var kbType by remember { mutableStateOf(isEmoji) }
    BasicTextField(
        textStyle = TextStyle(
            lineHeight = 22.sp,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            color = LocalAppColors.current.txt_primary
        ),
        state = content,
        cursorBrush = SolidColor(LocalAppColors.current.txt_brand),
        lineLimits = TextFieldLineLimits.MultiLine(maxHeightInLines = 3),
        decorator = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth().wrapContentHeight().background(LocalAppColors.current.bg_IM)
                    .padding(10.dp, 7.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.Bottom,
            ) {
                Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Box(
                        modifier = Modifier.fillMaxWidth().background(
                            LocalAppColors.current.bg_white_default,
                            RoundedCornerShape(6.dp)
                        ).padding(10.dp, 9.dp)
                    ) {
                        Box(Modifier.width(254.dp)) {
                            if (content.text.isBlank()) {
                                Text(
                                    "请输入消息...", style = TextStyle(
                                        fontWeight = FontWeight(400),
                                        fontSize = 16.sp,
                                        color = LocalAppColors.current.txt_disabled
                                    )
                                )
                            } else {
                                innerTextField()
                            }
                        }
                        Icon(
                            painter = painterResource(if (kbType) Res.drawable.ic_kb_type_kb else Res.drawable.ic_kb_type_emoji),
                            null,
                            modifier = Modifier.align(Alignment.BottomEnd).clickable {
                                kbType = !kbType
                            }
                        )
                    }

                    if (originalMessage.isNotBlank()) {
                        Box(
                            modifier = Modifier.fillMaxWidth().background(
                                LocalAppColors.current.bg_white_default,
                                RoundedCornerShape(6.dp)
                            ).padding(start = 10.dp, end = 15.33.dp, top = 6.dp, bottom = 6.dp)
                        ) {
                            Box(Modifier.width(259.dp)) {
                                if (content.text.isBlank()) {
                                    Text(
                                        originalMessage,
                                        style = TextStyle(
                                            fontWeight = FontWeight(400),
                                            fontSize = 12.sp,
                                            color = LocalAppColors.current.txt_disabled,
                                        ),
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                    )
                                } else {
                                    innerTextField()
                                }
                            }
                            Icon(
                                painter = painterResource(Res.drawable.ic_kb_delete),
                                null,
                                modifier = Modifier.align(Alignment.CenterEnd).clickable {
                                    originalMessage = ""
                                },
                                tint = Color.Unspecified
                            )
                        }
                    }

                }
                Row(modifier = Modifier.padding(vertical = 9.dp)) {
                    Icon(painterResource(Res.drawable.ic_kb_plus), null)

                }
            }
        }
    )
}

@Preview
@Composable
fun ChatInputPreview() {
    ChatInput(initialOriginalMessage = "用户昵称：文本文本文本文本文本文本文本文文")
}

