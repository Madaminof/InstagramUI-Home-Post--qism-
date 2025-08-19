package com.example.instagramprofile.Repository
import com.example.instagramprofile.data.PostApiService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PostRepository @Inject constructor(
    private val api: PostApiService
) {
    suspend fun getPosts() = api.getPosts()
}
