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
import androidx.compose.foundation.layout.*
import com.example.instagramprofile.R
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Brush

@Composable
fun Story(storiesList: List<Pair<Int, String>>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(storiesList.size, key = { index -> storiesList[index].second }) { index ->
            val (imageRes, username) = storiesList[index]

            // Bu joyda rememberImagePainter yoki shunchaki painterResource ishlatamiz
            val painter = painterResource(id = imageRes)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painter,
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .size(88.dp)
                        .clip(CircleShape)
                        .border(
                            width = 4.dp,
                            brush = Brush.sweepGradient(
                                colors = listOf(
                                    Color(0xFFF58529), // Orange
                                    Color(0xFFDD2A7B), // Pink
                                    Color(0xFF8134AF), // Purple
                                    Color(0xFF515BD4), // Blue
                                    Color(0xFFF58529)  // Orange (loop back for smooth blend)
                                )
                            ),
                            shape = CircleShape
                        )
                        .padding(4.dp), // gradient ichidan joy ochish
                    contentScale = ContentScale.Crop
                )


                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = username,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Gray
                    ),
                    maxLines = 1
                )
            }
        }
    }
}



val stories = listOf(
    R.drawable.r2 to "Your story",
    R.drawable.instagram_icon to "Instagram",
    R.drawable.icon to "Ali",
    R.drawable.cr to "CR 7",
    R.drawable.chuqur to "Chuqur",
    R.drawable.icon to "Jony",
    )


