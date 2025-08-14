package com.example.instagramprofile.Post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PostCaption(username: String, caption: String, time: String) {
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)) {
        // Username + caption
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                ) {
                    append(username)
                }
                append(" ")
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.onBackground
                    )
                ) {
                    append(caption)
                }
            },
            fontSize = 14.sp
        )

        // Time
        Text(
            text = time,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 1.dp)
        )
    }
}
