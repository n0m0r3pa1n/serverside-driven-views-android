package com.georgimirchev.network.api

import com.georgimirchev.network.data.VideoJson
import com.georgimirchev.network.data.paging.PageJson
import com.georgimirchev.networking.data.MiddlewareResult
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Url

interface VideoApi {
    @GET
    suspend fun getVideosByUrl(
        @Url url: String,
        @Header("key") key: String = "5e407320d6ea72303beea923e32f0425"
    ): MiddlewareResult<PageJson<VideoJson>>
}
