package com.lokesh.tweetappcompose.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tweet(
    @SerializedName(value = "category")
    var category: String? = null,
    @SerializedName(value = "tweet")
    var tweet: String? = null,
) : Parcelable