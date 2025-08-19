package com.example.instagramprofile.View.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.instagramprofile.Components.ButtonNavBar.BottomNavBar
import com.example.instagramprofile.Components.Header.Header
import com.example.instagramprofile.View.home.Post.InstagramPostCard
import com.example.instagramprofile.View.home.Stories.StorySection
import com.example.instagramprofile.ViewModel.PostViewModel
import androidx.navigation.NavController
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.layout.Box

@Composable
fun MainScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { Header(navController)},
        bottomBar = {
            BottomNavBar(
                navController = navController,
                selectedIndex = selectedIndex,
                onSelectedChange = { selectedIndex = it }
            )
        }
    ) { padding ->
        FeedScreen(padding = padding)
    }
}


@Composable
fun FeedScreen(
    viewModel: PostViewModel = hiltViewModel(),
    padding: PaddingValues = PaddingValues()
) {
    val posts by viewModel.posts.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(androidx.compose.ui.Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    StorySection()
                }

                items(posts) { post ->
                    InstagramPostCard(
                        post = post,
                        onLikeClick = { viewModel.toggleLike(post.id) },
                        onDoubleTapLike = { viewModel.likeIfNeeded(post.id) },
                        onCommentClick = { /* comment */ },
                        onShareClick = { /* share */ }
                    )
                }
            }
        }
    }
}
