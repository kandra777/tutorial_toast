package kmp.project.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmp.project.ui_kit.design.LocalAppColors
import kmp.project.ui_kit.ui.ChatInput

@Composable
fun ChatInputScreen(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize().background(LocalAppColors.current.bg_white_default)) {
        ChatInput()
        Spacer(Modifier.height(10.dp))
        ChatInput("输入多行内容，输入框向上规则移动，超出内容换行处理，多行不超过三行超过上下滚动")
        Spacer(Modifier.height(10.dp))
        ChatInput(isEmoji = true)
        Spacer(Modifier.height(10.dp))
        ChatInput(initialOriginalMessage = "用户昵称：文本文本文本文本文本文本文本文文")
        Spacer(Modifier.height(10.dp))
        ChatInput(initialOriginalMessage = "用户昵称：文本文本文本文本文本文本文本文文文本文本文本文本文本文本文本文文文本文本文本文本文本文本文本文文")
        Spacer(Modifier.height(10.dp))
    }
}










