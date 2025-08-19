package com.example.instagramprofile.Navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagramprofile.View.home.MainScreen
import com.example.instagramprofile.View.Profile.ProfileScreen
import com.example.instagramprofile.View.Reels.Reels
import com.example.instagramprofile.View.Search.SearchScreen
import com.example.instagramprofile.View.home.Chats.ChatList

object Routes {
    const val FEED = "feed"
    const val PROFILE = "profile"
    const val SEARCH = "search"
    const val REELS = "reels"
    const val CHATS = "chats"


}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.FEED,
        modifier = modifier
    ) {
        composable(Routes.FEED) {
            MainScreen(navController)
        }
        composable(Routes.PROFILE) {
            ProfileScreen(navController)
        }
        composable(Routes.SEARCH){
            SearchScreen(navController)
        }
        composable(Routes.REELS){
            Reels(navController)
        }
        composable(Routes.CHATS){
            ChatList(navController)
        }

    }
}
