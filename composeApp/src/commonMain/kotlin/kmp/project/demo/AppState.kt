package kmp.project.demo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navHostController: NavHostController = rememberNavController()
):AppState{
    return remember {
        AppState(coroutineScope,navHostController)
    }
}

@Stable
class AppState(coroutineScope: CoroutineScope, val navHostController: NavHostController) {

}