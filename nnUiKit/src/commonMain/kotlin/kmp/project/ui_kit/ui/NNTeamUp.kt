package kmp.project.ui_kit.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp.project.ui_kit.design.LocalAppColors
import kmp.project.ui_kit.toPaddedString
import kmpdemo.nnuikit.generated.resources.Res
import kmpdemo.nnuikit.generated.resources.ic_teamup_off_line
import kmpdemo.nnuikit.generated.resources.ic_teamup_room_is_full
import kmpdemo.nnuikit.generated.resources.ic_teamup_room_is_locked
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun NnTeamUpRTCQuited() {
    Row(
        Modifier
            .width(83.dp)
            .height(18.dp)
            .background(color = LocalAppColors.current.grey_tag_default, shape = RoundedCornerShape(size = 2.5.dp))
            .padding(start = 6.dp, end = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(painterResource(Res.drawable.ic_teamup_off_line), null, tint = Color.Unspecified)
        Text(
            text = "已退出语音",
            style = TextStyle(
                fontSize = 11.sp,
                lineHeight = 15.sp,
                fontWeight = FontWeight(400),
                color = LocalAppColors.current.txt_tertiary,
            )
        )
    }
}


@Preview
@Composable
fun NNTeamUpBlackRowPreview() {
    NNTeamUpBlackRow(
        roomNum = 123,
        slogan = "大乱斗4=1 来个妹妹或者姐姐",
        inRoomPeople = 8,
        capacity = 10
    )
}

@Composable
fun NNTeamUpBlackRow(roomNum: Int, slogan: String, inRoomPeople: Int, capacity: Int, isLocked: Boolean = false) {
    Row(
        modifier = Modifier
            .border(
                width = 0.5.dp,
                color = LocalAppColors.current.btn_black_default,
                shape = RoundedCornerShape(size = 2.5.dp)
            )
            .width(225.dp)
            .height(18.dp)
            .background(color = LocalAppColors.current.btn_black_default, shape = RoundedCornerShape(size = 2.5.dp))
            .padding(start = 2.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        val bgWhite = LocalAppColors.current.bg_white_default
        val golden = LocalAppColors.current.txt_golden

        Text(
            roomNum.toString(),
            modifier = Modifier
                .padding(0.dp)
                .wrapContentWidth()
                .height(14.dp)
                .background(color = LocalAppColors.current.txt_golden, shape = RoundedCornerShape(size = 1.dp))
                .padding(start = 6.dp, top = 1.5.dp, end = 6.dp, bottom = 1.5.dp),
            style = TextStyle(
                fontSize = 10.sp,
                lineHeight = 11.sp,
                fontWeight = FontWeight(500),
                color = LocalAppColors.current.txt_title,
                textAlign = TextAlign.Center,
            )
        )
        Text(
            slogan, Modifier
                .padding(start = 4.dp)
                .width(143.dp)
                .height(15.dp), style = TextStyle(
                fontSize = 11.sp,
                lineHeight = 15.sp,
                fontWeight = FontWeight(400),
                color = LocalAppColors.current.txt_white
            )
        )
        if (isLocked) {
            Row(
                modifier = Modifier.weight(1f).fillMaxHeight().background(color = golden),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painterResource(Res.drawable.ic_teamup_room_is_locked), null, tint = Color.Unspecified)
                Spacer(Modifier.width(2.dp))
                Text(
                    text = "已锁",
                    style = TextStyle(
                        fontSize = 11.sp,
                        lineHeight = 14.sp,
                        fontWeight = FontWeight(600),
                        color = LocalAppColors.current.txt_title,
                    )
                )
            }
        } else if (inRoomPeople == capacity) {
            Row(
                modifier = Modifier.weight(1f).fillMaxHeight().background(color = golden),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painterResource(Res.drawable.ic_teamup_room_is_full), null, tint = Color.Unspecified)
                Spacer(Modifier.width(2.dp))
                Text(
                    text = "已满",
                    style = TextStyle(
                        fontSize = 11.sp,
                        lineHeight = 14.sp,
                        fontWeight = FontWeight(600),
                        color = LocalAppColors.current.txt_title,
                    )
                )
            }

        } else {
            Text(
                inRoomPeople.toPaddedString(),
                modifier = Modifier.padding(start = 4.dp).weight(1f).fillMaxHeight().background(
                    LocalAppColors.current.bg_white
                ).padding(start = 5.5.dp, end = 1.5.dp, top = 2.dp, bottom = 2.dp), style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight(600),
                    color = LocalAppColors.current.txt_title,
                )
            )

            Canvas(modifier = Modifier.fillMaxHeight().width(6.dp)) {
                val trianglePath = Path().let {
                    it.moveTo(0f, 0f)
                    it.lineTo(this.size.width, 0f)
                    it.lineTo(0f, this.size.height)
                    it.close()
                    it
                }

                val trianglePath2 = Path().let {
                    it.moveTo(this.size.width, 0f)
                    it.lineTo(0f, this.size.height)
                    it.lineTo(this.size.width, this.size.height)
                    it.close()
                    it
                }


                drawPath(
                    path = trianglePath,
                    SolidColor(bgWhite)
                )

                drawPath(
                    path = trianglePath2,
                    SolidColor(golden)
                )

            }
            Text(
                capacity.toPaddedString(),
                modifier = Modifier.fillMaxHeight().weight(1f).background(
                    LocalAppColors.current.txt_golden
                ).padding(start = 2.5.dp, end = 6.5.dp, top = 2.dp, bottom = 2.dp), style = TextStyle(
                    fontSize = 11.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight(600),
                    color = LocalAppColors.current.txt_title,
                )

            )

        }


    }
}

