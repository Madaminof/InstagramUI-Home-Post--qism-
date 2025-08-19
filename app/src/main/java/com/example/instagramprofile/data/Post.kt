package com.example.instagramprofile.data


data class Post(
    val id: Int,
    val avatarRes: String,
    val username: String,
    val imgVideoRes: String,
    val caption: String,
    val time: String,
    val likeCount: Int = 0,
    val isLiked: Boolean = false,
    val commentCount: String,
    val shareCount: String
)

