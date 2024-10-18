package com.lokesh.tweetappcompose.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.lokesh.tweetappcompose.models.Tweet
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetTweetsResponse(
    @field:SerializedName("records")
    var records: ArrayList<Tweet>? = null
) : Parcelable
