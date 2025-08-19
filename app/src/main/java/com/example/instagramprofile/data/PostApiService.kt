package com.example.instagramprofile.data

import retrofit2.http.GET

interface PostApiService {
    @GET("posts") // bu endpoint sizning mock API endpoint bo'ladi
    suspend fun getPosts(): List<Post>
}
