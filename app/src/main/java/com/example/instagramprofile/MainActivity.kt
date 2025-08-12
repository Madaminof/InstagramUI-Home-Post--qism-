package com.example.instagramprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import com.example.instagramprofile.Header.Header
import androidx.compose.material3.Scaffold
import com.example.instagramprofile.Stories.Story
import com.example.instagramprofile.Stories.stories
import androidx.compose.foundation.lazy.LazyColumn
import com.example.instagramprofile.Post.InstagramPostCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                topBar = { Header() }
            ) { padding ->

                LazyColumn(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                ) {
                    item {
                        Story(storiesList = stories)
                       InstagramPostCard()
                        InstagramPostCard()

                    }

                    // boshqa elementlar...
                }
            }
        }


    }
}


