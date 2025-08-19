package com.example.instagramprofile.View.home.Post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.instagramprofile.data.Post



@Composable
fun InstagramPostCard(
    post: Post,
    onLikeClick: () -> Unit,
    onDoubleTapLike: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        PostHeader(
            avatarRes = post.avatarRes,  // String URL
            username = post.username,
            onMoreClick = {
                // Bu yerda "More" tugmasi bosilganda nima bo‘lishini yozish mumkin
            }
        )


        PostMedia(
            mediaUrl = post.imgVideoRes, // endi rasm yoki video bo'lishi mumkin
            onDoubleTapLike = onDoubleTapLike
        )


        PostActions(
            post = post,
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick
        )

        PostCaption(
            username = post.username,
            caption = post.caption,
            time = post.time
        )
    }
}
