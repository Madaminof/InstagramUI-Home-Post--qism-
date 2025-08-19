package com.example.instagramprofile.View.home.Chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.instagramprofile.Components.ButtonNavBar.BottomNavBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.instagramprofile.ViewModel.PostViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.background

@Composable
fun ChatList(
    navController: NavController
){
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { HeaderChat() },
        bottomBar = { BottomNavBar(
            navController = navController,
            selectedIndex = selectedIndex,
            onSelectedChange = {selectedIndex = it}
        ) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        ResultList(padding = padding)
    }


}


@Composable
fun ResultList(
    viewModel: PostViewModel = hiltViewModel(),
    padding: PaddingValues = PaddingValues()
) {
    val chatList by viewModel.posts.collectAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(androidx.compose.ui.Alignment.Center)
            )
        }else{
            LazyColumn(
                contentPadding = padding
            ) {
                items(chatList) { chat ->
                    ChatListItem(
                        profileImage = chat.avatarRes, // agar profileImage chat ichida bo'lsa
                        username = chat.username,
                        lastActive = chat.time
                    )
                }
            }
        }
    }


}

@Composable
fun ChatListItem(
    profileImage:String,
    username:String,
    lastActive:String,
    onClick: () -> Unit = {}
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(profileImage),
            contentDescription = "profileImage",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = username,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
            Text(
                text = lastActive,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.Gray
                )
            )
        }
        // Right icon
        Icon(
            imageVector = Icons.Default.PhotoCamera, // o‘zingiz xohlagan icon
            contentDescription = "Action Icon",
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.size(24.dp)
        )
    }

}





@Composable
fun HeaderChat(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background) // fon rangi
            .padding(top = 36.dp, start = 16.dp, end = 16.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Back icon + Username yonma-yon
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .size(40.dp) // icon kattaroq
                    .clip(CircleShape)
                    .clickable { /* orqaga qaytish */ }
                    .padding(6.dp)
            )

            Spacer(modifier = Modifier.width(12.dp)) // orani ochish

            Text(
                text = "sames_o2",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
        }


        // o'ng tomondagi icon
        Icon(
            imageVector = Icons.Default.BorderColor,
            contentDescription = "Edit",
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .clickable { /* Edit bosilganda amal */ }
                .padding(4.dp)
        )
    }
}











