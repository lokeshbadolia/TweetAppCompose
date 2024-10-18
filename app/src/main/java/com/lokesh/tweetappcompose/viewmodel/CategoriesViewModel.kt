package com.lokesh.tweetappcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lokesh.tweetappcompose.remote.ApiHelper
import com.lokesh.tweetappcompose.response.GetCategoriesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val apiHelper: ApiHelper) : ViewModel() {

    val categories: StateFlow<GetCategoriesResponse?>
        get() = apiHelper.categories

    init {
        viewModelScope.launch(Dispatchers.IO) {
            apiHelper.getCategories()
        }
    }
}