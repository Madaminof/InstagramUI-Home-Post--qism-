package com.example.instagramprofile.Post

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun PostActions(
    likeCount: String,
    commentCount: String,
    shareCount: String,
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 8.dp, bottom = 8.dp)
    ) {
        // ❤️ Like
        ActionItem(
            icon = if (isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            tint = if (isLiked) Color.Red else MaterialTheme.colorScheme.onBackground,
            count = likeCount,
            onClick = onLikeClick
        )

        Spacer(modifier = Modifier.width(20.dp))

        // 💬 Comment
        ActionItem(
            icon = Icons.Default.Comment,
            tint = MaterialTheme.colorScheme.onBackground,
            count = commentCount,
            onClick = onCommentClick
        )

        Spacer(modifier = Modifier.width(20.dp))

        // 📤 Share
        ActionItem(
            icon = Icons.Default.Send,
            tint = MaterialTheme.colorScheme.onBackground,
            count = shareCount,
            onClick = onShareClick
        )
    }
}



@Composable
fun ActionItem(
    icon: ImageVector,
    tint: Color,
    count: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tint,
            modifier = Modifier
                .size(32.dp) // biroz kattaroq
                .padding(4.dp) // bosish maydonini kengaytirish
                .clickable(
                    onClick = onClick,
                    indication = null, // ripple effektini olib tashlash
                    interactionSource = remember { MutableInteractionSource() }
                )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
