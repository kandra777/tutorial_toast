package kmp.project.ui_kit.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp.project.ui_kit.design.LocalAppColors
import kmpdemo.nnuikit.generated.resources.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalResourceApi::class)
@Composable
fun NNCenterTopBar(
    startIconIsBack: Boolean = true,
    title: String,
    isShowImagesRow: Boolean = false,
    isShowEndContent: Boolean = true,
    endContentIsConfirm: Boolean = true
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(48.dp).background(LocalAppColors.current.bg_white)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        Box(Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
            Icon(
                painter = painterResource(if (startIconIsBack) Res.drawable.ic_topbar_back else Res.drawable.ic_topbar_close),
                null
            )
        }

        Text(
            text = title.take(3),
            fontSize = 18.sp,
            color = LocalAppColors.current.txt_title,
            fontWeight = FontWeight(600)
        )
        Box(Modifier.weight(1f), contentAlignment = Alignment.CenterEnd) {
            if (isShowImagesRow) {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Icon(painterResource(Res.drawable.compose_logo), null, Modifier.size(24.dp))
                    Icon(painterResource(Res.drawable.compose_logo), null, Modifier.size(24.dp))
                    Icon(painterResource(Res.drawable.compose_logo), null, Modifier.size(24.dp))

                    if (isShowEndContent) {
                        if (endContentIsConfirm) {
                            Text(
                                modifier = Modifier.weight(1f, fill = false),
                                text = "确定",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 14.sp,
                                color = LocalAppColors.current.txt_brand,
                                fontWeight = FontWeight(600)
                            )

                        } else {
                            Icon(
                                painterResource(Res.drawable.ic_topbar_more),
                                null,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            } else {
                if (isShowEndContent) {
                    if (endContentIsConfirm) {
                        Text(
                            modifier = Modifier,
                            text = "确定",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 14.sp,
                            color = LocalAppColors.current.txt_brand,
                            fontWeight = FontWeight(600)
                        )

                    } else {
                        Icon(
                            painterResource(Res.drawable.ic_topbar_more),
                            null,
                            modifier = Modifier
                        )
                    }
                }

            }


        }
    }

}

@Composable
fun NNTemporaryChatTopBar(
    nickName: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(48.dp).background(LocalAppColors.current.bg_white)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_topbar_back),
            null
        )
        Column(modifier = Modifier.padding(start = 6.dp)) {
            Text(
                text = nickName,
                fontSize = 14.sp,
                color = LocalAppColors.current.txt_title,
                fontWeight = FontWeight(600)
            )
            Text(
                text = "临时聊天",
                fontSize = 10.sp,
                color = LocalAppColors.current.txt_secondary,
                fontWeight = FontWeight(600)
            )
        }

        Box(Modifier.weight(1f), contentAlignment = Alignment.CenterEnd) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Box(
                    Modifier.size(60.dp, 28.dp).clip(RoundedCornerShape(14.dp))
                        .background(LocalAppColors.current.btn_main_default), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "添加",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = LocalAppColors.current.bg_white_default,
                        )
                    )
                }
                Icon(
                    painterResource(Res.drawable.ic_topbar_more),
                    null,
                    modifier = Modifier
                )
            }


        }


    }


}


@Composable
fun NNRoomTopBar(
    roomNumber: String,
    roomName: String,
    images: List<String>
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(48.dp).background(LocalAppColors.current.bg_white)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_topbar_close),
            null
        )
        Row(modifier = Modifier.padding(start = 6.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.wrapContentSize()
                    .background(color = Color.Black, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 6.dp, vertical = 3.5.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = roomNumber,
                    lineHeight = 11.sp,
                    fontSize = 11.sp,
                    color = LocalAppColors.current.bg_white_default,
                    fontWeight = FontWeight(500)
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = roomName,
                modifier = Modifier.widthIn(max = 147.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                color = LocalAppColors.current.txt_title,
                fontWeight = FontWeight(600)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Icon(painterResource(Res.drawable.compose_logo), null, Modifier.size(24.dp))
                Icon(painterResource(Res.drawable.compose_logo), null, Modifier.size(24.dp))
                Icon(painterResource(Res.drawable.compose_logo), null, Modifier.size(24.dp))
            }
        }

        Box(Modifier.weight(1f), contentAlignment = Alignment.CenterEnd) {

            Icon(
                painterResource(Res.drawable.ic_topbar_more),
                null,
                modifier = Modifier
            )


        }


    }


}

@Composable
fun NNCommunityTopBar(
    icon: String,
    NNCommunityName: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(48.dp).background(LocalAppColors.current.bg_white)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_topbar_back),
            null
        )
        Row(modifier = Modifier.padding(start = 6.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(Res.drawable.compose_logo), null, Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = NNCommunityName,
                modifier = Modifier.widthIn(max = 192.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                color = LocalAppColors.current.txt_title,
                fontWeight = FontWeight(600)
            )

        }

        Box(Modifier.weight(1f), contentAlignment = Alignment.CenterEnd) {

            Icon(
                painterResource(Res.drawable.ic_topbar_more),
                null,
                modifier = Modifier
            )


        }


    }


}

@Composable
fun NNDiscoveryTopBar(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth().height(48.dp).background(LocalAppColors.current.bg_white)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
    ) {
        Text(
            "发现", style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                fontWeight = FontWeight(400),
                color = LocalAppColors.current.txt_secondary,
            )
        )

        Text(
            title, modifier = Modifier.padding(start = 24.dp),
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 26.sp,
                fontWeight = FontWeight(600),
                color = LocalAppColors.current.txt_title
            )
        )

        Box(Modifier.weight(1f), contentAlignment = Alignment.CenterEnd) {

            Icon(
                painterResource(Res.drawable.ic_topbar_more),
                null,
                modifier = Modifier
            )


        }
    }
}

@Preview
@Composable
fun NNDisCoveryTopBarPreview() {
    NNDiscoveryTopBar("绝地求生")
}


@Preview
@Composable
fun NNcenterTopBarPreview() {
    NNCenterTopBar(title = "导航栏")
}


@Preview
@Composable
fun NNTemporaryChatTopBarPreview() {
    NNTemporaryChatTopBar("用户昵称")
}

@Preview
@Composable
fun NNRoomTopBarTopBarPreview() {
    NNRoomTopBar(
        roomNumber = "16",
        roomName = "最多显示8个字饭啊开伞疯狂塞",
        images = listOf("1", "2", "3")
    )
}





