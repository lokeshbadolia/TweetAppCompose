package com.lokesh.tweetappcompose.remote

import com.lokesh.tweetappcompose.models.Tweet
import com.lokesh.tweetappcompose.response.GetCategoriesResponse
import com.lokesh.tweetappcompose.response.GetTweetsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {

    @GET("v3/b/65d871d11f5677401f3343d4")
    suspend fun getCategories(@Header("X-Bin-Meta") needMeta:Boolean = false): Response<GetCategoriesResponse>

    @GET("v3/b/65d8653f1f5677401f333fce")
    suspend fun getTweets(@Header("X-Bin-Meta") needMeta:Boolean = false, @Header("X-JSON-Path") category:String): Response<ArrayList<Tweet>>
}
