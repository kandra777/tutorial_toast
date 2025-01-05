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
import kmp.project.ui_kit.ui.NNTeamUpBlackRow
import kmp.project.ui_kit.ui.NnTeamUpRTCQuited

@Composable
fun TeamUpScreen(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize().background(LocalAppColors.current.bg_white_default)) {
        NNTeamUpBlackRow(
            roomNum = 99,
            slogan = "大乱斗4=1 来个妹妹或者姐姐",
            inRoomPeople = 8,
            capacity = 10
        )
        Spacer(Modifier.height(10.dp))
        NNTeamUpBlackRow(
            roomNum = 123,
            slogan = "大乱斗4=1 来个妹妹或者姐姐",
            inRoomPeople = 10,
            capacity = 10
        )
        Spacer(Modifier.height(10.dp))
        NNTeamUpBlackRow(
            roomNum = 234,
            slogan = "大乱斗4=1 来个妹妹或者姐姐",
            inRoomPeople = 10,
            capacity = 10,
            isLocked = true
        )
        Spacer(Modifier.height(10.dp))
        NnTeamUpRTCQuited()


    }
}








