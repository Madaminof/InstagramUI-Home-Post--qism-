package com.example.instagramprofile.data

import retrofit2.http.GET


interface StoryApiServise {
    @GET("stories")
    suspend fun getStories(): List<Story>
}

