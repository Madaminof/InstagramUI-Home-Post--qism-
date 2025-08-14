package com.example.instagramprofile.Post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.instagramprofile.R
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun InstagramPostCard() {
    var isLiked by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        PostHeader(
            avatarRes = R.drawable.r2,
            username = "sames_o2"
        )

        PostImage(imageRes = R.drawable.r1, onDoubleTapLike = { isLiked = true } // ikki marta bosilganda like bo‘ladi
        )

        PostActions(
            likeCount = "100k",
            commentCount = "10k",
            shareCount = "50k",
            isLiked = isLiked,
            onLikeClick = { isLiked = !isLiked }, // bosilganda like o‘zgaradi
            onCommentClick = { /* comment bosilganda nima bo‘lishini yoz */ },
            onShareClick = { /* share bosilganda nima bo‘lishini yoz */ },
        )


        PostCaption(
            username = "sames_o2",
            caption = " Mobile Developer ",
            time = "2 days ago"
        )


        PostHeader(
            avatarRes = R.drawable.r4,
            username = "samandar_dev"
        )

        PostImage(imageRes = R.drawable.r3, onDoubleTapLike = { isLiked = true } // ikki marta bosilganda like bo‘ladi
        )

        PostActions(
            likeCount = "2k",
            commentCount = "712",
            shareCount = "256",
            isLiked = isLiked,
            onLikeClick = { isLiked = !isLiked }, // bosilganda like o‘zgaradi
            onCommentClick = { /* comment bosilganda nima bo‘lishini yoz */ },
            onShareClick = { /* share bosilganda nima bo‘lishini yoz */ },
        )


        PostCaption(
            username = "samandar_dev",
            caption = "Bugun yangi loyihamni boshladim 🚀",
            time = "6 days ago"
        )



    }
}










