package kmp.project.ui_kit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp.project.ui_kit.design.LocalAppColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NNTimeDivider(modifier: Modifier = Modifier, time: String) {
    Row(
        modifier = Modifier.fillMaxWidth().height(32.dp).background(LocalAppColors.current.bg_defaul),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            time, style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = LocalAppColors.current.txt_tertiary,
                textAlign = TextAlign.Justify,
            )
        )
    }
}

@Composable
fun NNDetailDivider(modifier: Modifier = Modifier, des: String, onDetailClicked: () -> Unit = {}) {
    Row(
        modifier = Modifier.fillMaxWidth().height(32.dp).background(LocalAppColors.current.bg_defaul),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            des, style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = LocalAppColors.current.txt_tertiary,
                textAlign = TextAlign.Justify,
            )
        )
        Text(
            "查看详情", style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = LocalAppColors.current.txt_brand,
            ), modifier = Modifier.padding(start = 4.dp).clickable {
                onDetailClicked.invoke()
            }
        )
    }
}

@Composable
fun NNUnsendDivider(modifier: Modifier = Modifier, nickName: String) {
    Row(
        modifier = Modifier.fillMaxWidth().height(32.dp).background(LocalAppColors.current.bg_defaul),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            "\"$nickName\"", style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = LocalAppColors.current.txt_tertiary,
                textAlign = TextAlign.Justify,
            )
        )
        Text(
            "撤回了一条消息", style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = LocalAppColors.current.txt_tertiary,
                textAlign = TextAlign.Justify,
            )
        )
    }
}

@Composable
fun NNNotificationDivider(modifier: Modifier = Modifier, content: String) {
    Box(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().background(LocalAppColors.current.bg_defaul)
            .padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 10.dp)
    ) {
        Text(
            content,
            modifier = Modifier.background(
                color = LocalAppColors.current.grey_tag_default,
                shape = RoundedCornerShape(size = 8.dp)
            )
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp), style = TextStyle(
                fontSize = 11.sp,
                lineHeight = 15.sp,
                fontWeight = FontWeight(400),
                color = LocalAppColors.current.txt_tertiary,
                textAlign = TextAlign.Justify,
            )
        )
    }
}

@Composable
fun NNHorizontalDivider(
    modifier: Modifier = Modifier.fillMaxWidth(),
    thickness: Dp = 0.5.dp,
    color: Color = LocalAppColors.current.border_default
) {
    HorizontalDivider(modifier = modifier, thickness = thickness, color = color)
}

@Preview
@Composable
fun NNTimeDividerPreview() {
    NNTimeDivider(time = "昨天 14::20")
}

@Preview
@Composable
fun NNDetailDividerPreview() {
    NNDetailDivider(des = "对方超时未响应你的订单")
}

@Preview
@Composable
fun NNUnsendDividerPreview() {
    NNUnsendDivider(nickName = "昵称昵称昵称昵称昵称称昵昵称昵称昵称称昵")
}


@Preview
@Composable
fun NNNotificationDividerPreview() {
    NNNotificationDivider(content = "频道倡导绿色健康互动，严禁未成年人充值消费，严禁涉及政治、色情、广告、刷屏、谩骂等违规内容，违者根据情节给与功能封禁、平台账户永久封禁等处罚，欢迎大家对违规信息右键举报，共建和谐社区!")
}






