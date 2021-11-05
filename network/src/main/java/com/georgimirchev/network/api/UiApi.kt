package com.georgimirchev.network.api

import com.georgimirchev.network.data.UiJson
import com.georgimirchev.networking.data.MiddlewareResult
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UiApi {
    @GET("ui")
    suspend fun getLayout(
        @Query("path", encoded = false) path: String,
        @Header("key") key: String = "5e407320d6ea72303beea923e32f0425"
    ): MiddlewareResult<UiJson>

    @GET("ui")
    suspend fun getLayoutWithToken(
        @Header("miratoken") miratoken: String,
        @Header("environment") environment: String,
        @Query("path", encoded = false) path: String
    ): MiddlewareResult<UiJson>
}

