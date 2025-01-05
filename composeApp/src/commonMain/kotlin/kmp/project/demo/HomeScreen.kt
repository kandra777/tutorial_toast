package kmp.project.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kmp.project.ui_kit.design.LocalAppColors


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    goToTopBarScreen: () -> Unit,
    goToChatInputScreen: () -> Unit,
    goToTeamUpScreen: () -> Unit,
    goToDividerScreen: () -> Unit,
    goToShimmerScreen: () -> Unit,
    goToShortShimmerScreen: () -> Unit,
    goToUserListScreen: () -> Unit,
    goToSegmentedButtonScreen: () -> Unit,
    goToTabLayoutScreen: () -> Unit,
) {
    LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(12.dp)) {
        item {
            CategoryItem("导航栏") {
                goToTopBarScreen.invoke()
            }
        }
        item {
            CategoryItem("用户列表") {
                goToUserListScreen.invoke()
            }
        }
        item {
            CategoryItem("聊天输入框") {
                goToChatInputScreen.invoke()
            }
        }

        item {
            CategoryItem("组队小黑条") {
                goToTeamUpScreen.invoke()
            }
        }
        item {
            CategoryItem("间隔/分割栏") {
                goToDividerScreen.invoke()
            }
        }
        item {
            CategoryItem("骨架屏长") {
                goToShimmerScreen.invoke()
            }
        }
        item {
            CategoryItem("骨架屏短") {
                goToShortShimmerScreen.invoke()
            }
        }

        item {
            CategoryItem("分段按钮") {
                goToSegmentedButtonScreen.invoke()
            }
        }

        item {
            CategoryItem("TabLayout") {
                goToTabLayoutScreen.invoke()
            }
        }


    }


}

@Composable
fun CategoryItem(itemName: String, onItemClicked: () -> Unit) {
    Text(
        itemName,
        style = TextStyle(color = LocalAppColors.current.txt_primary),
        modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(12.dp).clickable {
            onItemClicked.invoke()
        })
}
