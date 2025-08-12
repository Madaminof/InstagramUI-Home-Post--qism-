package com.example.instagramprofile.Stories

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import com.example.instagramprofile.R




@Composable
fun Story(storiesList: List<Pair<Int, String>>) {
    LazyRow {
        items(storiesList.size) { index ->
            val (imageRes, username) = storiesList[index]
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "User Avatar",
                    modifier = Modifier.size(64.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(text = username)
            }
        }

    }
}
val stories = listOf(
    R.drawable.avatar1 to "Samandar",
    R.drawable.avatar2 to "Ali",
    R.drawable.avatar3 to "Zara",
    R.drawable.cr to "CR 7",
    R.drawable.chuqur to "Chuqur",
    R.drawable.s2 to "Jony",
    )


