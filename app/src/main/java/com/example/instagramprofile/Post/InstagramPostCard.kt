package com.example.instagramprofile.Post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramprofile.R


@Composable
fun InstagramPostCard() {
    Column(modifier = Modifier.fillMaxWidth()) {
        PostHeader(
            avatarRes = R.drawable.avatar,
            username = "samandar_dev"
        )

        PostImage(imageRes = R.drawable.post_image)

        PostActions(
            likeCount = 120,
            commentCount = 10,
            shareCount = 230,
            onLikeClick = { /* like bosilganda nima bo‘lishini yoz */ },
            onCommentClick = { /* comment bosilganda nima bo‘lishini yoz */ },
            onShareClick = { /* share bosilganda nima bo‘lishini yoz */ }
        )


        PostCaption(
            username = "samandar_dev",
            caption = "Bugun yangi loyihamni boshladim 🚀",
            time = "6 days ago"
        )
    }
}





@Composable
fun PostHeader(avatarRes: Int, username: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 16.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = avatarRes),
                contentDescription = "User Avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Gray),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = username,
                fontSize = 14.sp
            )
        }
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More",
            modifier = Modifier.size(24.dp)
        )
    }
}




@Composable
fun PostImage(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = "Post Image",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun PostActions(
    likeCount: Int,
    commentCount: Int,
    shareCount: Int,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Start, // chapdan boshlash
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Like biroz o'ngga surish uchun padding qo'shamiz
        ActionItem(
            icon = Icons.Default.FavoriteBorder,
            count = likeCount,
            onClick = onLikeClick,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.width(24.dp))

        ActionItem(
            icon = Icons.Default.Comment,
            count = commentCount,
            onClick = onCommentClick,
            modifier = Modifier.padding(start = 0.dp)
        )
        Spacer(modifier = Modifier.width(24.dp))

        ActionItem(
            icon = Icons.Default.Share,
            count = shareCount,
            onClick = onShareClick,
            modifier = Modifier.padding(start = 0.dp)
        )
    }
}

@Composable
fun ActionItem(
    icon: ImageVector,
    count: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier  // modifier ni parametr sifatida olamiz
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clickable { onClick() }
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.bodySmall
        )
    }
}




@Composable
fun PostCaption(username: String, caption: String, time: String) {
    Text(
        text = "$username  $caption",
        fontSize = 14.sp,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
    Text(
        text = time,
        fontSize = 12.sp,
        modifier = Modifier.padding(horizontal = 16.dp),
        color = Color.Gray // vaqtni biroz noaniqroq qilish uchun
    )
}
