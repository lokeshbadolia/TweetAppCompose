package com.lokesh.tweetappcompose.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lokesh.tweetappcompose.models.Tweet
import com.lokesh.tweetappcompose.remote.ApiHelper
import com.lokesh.tweetappcompose.response.GetCategoriesResponse
import com.lokesh.tweetappcompose.response.GetTweetsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TweetsViewModel @Inject constructor(
    private val apiHelper: ApiHelper,
    private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val tweets: StateFlow<ArrayList<Tweet>?>
        get() = apiHelper.tweets

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val category = savedStateHandle.get<String>("category") ?: "Travel"
            apiHelper.getTweets(category)
        }
    }
}