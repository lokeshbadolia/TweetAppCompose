package com.lokesh.tweetappcompose.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.lokesh.tweetappcompose.models.Tweet
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetCategoriesResponse(
    @field:SerializedName("categories")
    var categories: ArrayList<String>? = null
) : Parcelable
