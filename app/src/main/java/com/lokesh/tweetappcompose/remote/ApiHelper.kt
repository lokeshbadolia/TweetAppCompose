package com.lokesh.tweetappcompose.remote

import com.lokesh.tweetappcompose.models.Tweet
import com.lokesh.tweetappcompose.remote.ApiService
import com.lokesh.tweetappcompose.response.GetCategoriesResponse
import com.lokesh.tweetappcompose.response.GetTweetsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) {

    private val _categories = MutableStateFlow<GetCategoriesResponse?>(null)
    val categories: StateFlow<GetCategoriesResponse?>
        get() = _categories

    suspend fun getCategories() {
        val response = apiService.getCategories()
        if (response.isSuccessful && response.body() != null){
            _categories.emit(response.body())
        }
    }

    /** -------------------------- */

    private val _tweets = MutableStateFlow<ArrayList<Tweet>?>(null)
    val tweets: StateFlow<ArrayList<Tweet>?>
        get() = _tweets

    suspend fun getTweets(category: String) {
        val response = apiService.getTweets(category = "records[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null){
            _tweets.emit(response.body())
        }
    }
}