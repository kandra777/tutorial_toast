package kmp.project.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmp.project.ui_kit.design.LocalAppColors
import kmp.project.ui_kit.ui.*

@Composable
fun TopBarScreen(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize().background(LocalAppColors.current.bg_defaul)) {
        NNCenterTopBar(
            title = "导航类类型1",
            startIconIsBack = true,
            isShowImagesRow = true,
            isShowEndContent = true,
            endContentIsConfirm = true,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
        NNCenterTopBar(
            title = "导航类类型2",
            startIconIsBack = false,
            isShowImagesRow = false,
            isShowEndContent = true,
            endContentIsConfirm = true,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
        NNCenterTopBar(
            title = "导航类类型3",
            startIconIsBack = false,
            isShowImagesRow = false,
            isShowEndContent = true,
            endContentIsConfirm = false,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
        NNCenterTopBar(
            title = "导航类类型4",
            startIconIsBack = false,
            isShowImagesRow = false,
            isShowEndContent = false,
            endContentIsConfirm = true,
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
        NNTemporaryChatTopBar("用户昵称")
        Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
        NNRoomTopBar("16", "饭狂傲三分空大经费", listOf("1", "2", "3"))
        Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
        NNCommunityTopBar("", "最多就这么长的字烦死床单疯狂三疯狂赛季疯狂赛经理")
        Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
        NNDiscoveryTopBar("绝地求生")
    }
}

