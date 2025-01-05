package kmp.project.demo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kmp.project.demo.*

@Composable
fun NNNavHost(appState: AppState, modifier: Modifier = Modifier) {
    val navHostController = appState.navHostController

    NavHost(
        navController = navHostController,
        startDestination = Home,
        modifier = modifier
    ) {
        composable<Home> {
            HomeScreen(
                goToTopBarScreen = { navHostController.navigate(TopBar) },
                goToChatInputScreen = { navHostController.navigate(ChatInput) },
                goToTeamUpScreen = { navHostController.navigate(TeamUp) },
                goToDividerScreen = { navHostController.navigate(Divider) },
                goToShimmerScreen = { navHostController.navigate(Shimmer) },
                goToShortShimmerScreen = { navHostController.navigate(ShortShimmer) },
                goToUserListScreen = { navHostController.navigate(UserList) },
                goToSegmentedButtonScreen = { navHostController.navigate(SegmentedButton) },
                goToTabLayoutScreen = { navHostController.navigate(TabLayout) },
            )

        }

        composable<TopBar> {
            TopBarScreen()
        }

        composable<ChatInput> {
            ChatInputScreen()
        }

        composable<TeamUp> {
            TeamUpScreen()
        }

        composable<Divider> {
            DividerScreen()
        }
        composable<Shimmer> {
            ShimmerScreen()
        }

        composable<ShortShimmer> {
            ShortShimmerScreen()
        }

        composable<UserList> {
            UserListScreen()
        }

        composable<SegmentedButton> {
            SegmentedButtonScreen()
        }

        composable<TabLayout> {
            TabLayoutScreen()
        }

    }

}


