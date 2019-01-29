package com.yaaqoub.topicapp.network

import com.yaaqoub.topicapp.model.Topic
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("/v2/5c5076fa34000057001298de")
    fun getPosts(): Deferred<Response<List<Topic>>>
}