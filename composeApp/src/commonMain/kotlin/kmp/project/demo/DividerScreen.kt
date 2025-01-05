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
import kmp.project.ui_kit.ui.*

@Composable
fun DividerScreen(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize().background(LocalAppColors.current.bg_white_default)) {
        NNTimeDivider(time = "昨天 14::21")
        Spacer(Modifier.height(10.dp))
        NNDetailDivider(des = "对方超时为响应你的订单")
        Spacer(Modifier.height(10.dp))
        NNUnsendDivider(nickName = "热情的沙松")
        Spacer(Modifier.height(10.dp))
        NNNotificationDivider(content = "频道倡导绿色健康互动，严禁未成年人充值消费，严禁涉及政治、色情、广告、刷屏、谩骂等违规内容，违者根据情节给与功能封禁、平台账户永久封禁等处罚，欢迎大家对违规信息右键举报，共建和谐社区!")
        Spacer(Modifier.height(10.dp))
        NNHorizontalDivider()
        Spacer(Modifier.height(10.dp))
        NNHorizontalDivider(thickness = 10.dp)
    }
}

