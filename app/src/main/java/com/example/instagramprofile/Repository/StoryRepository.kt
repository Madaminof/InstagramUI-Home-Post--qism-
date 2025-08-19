package com.example.instagramprofile.Repository

import com.example.instagramprofile.data.Story
import com.example.instagramprofile.data.StoryApiServise
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class StoryRepository @Inject constructor(
    private val api: StoryApiServise
) {
    suspend fun getStories(): List<Story> = api.getStories()
}
