package com.example.instagramprofile.Header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp, start = 16.dp, end = 16.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Instagram", fontWeight = FontWeight.Bold, fontSize = 26.sp)
        Row {
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Notifications", modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Icon(imageVector = Icons.Default.Send, contentDescription = "Send", modifier = Modifier.size(24.dp))
        }
    }
}
