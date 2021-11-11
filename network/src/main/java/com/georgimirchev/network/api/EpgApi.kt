package com.georgimirchev.network.api

import com.georgimirchev.network.data.EpgEntryJson
import com.georgimirchev.network.data.paging.PageJson
import com.georgimirchev.networking.data.MiddlewareResult
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface EpgApi {
    @GET("epg/now")
    suspend fun getEpgAllNow(
        @Header("key") key: String = "5e407320d6ea72303beea923e32f0425",
        @Query("limit") limit: Int? = 50,
        @Query("sortOrder") sortOrder: String = "presetOrder",
        @Query("channelId") channels: String = "1,2,3,4,5,6,7",
        @Query("selection") selection: String
    ): MiddlewareResult<PageJson<EpgEntryJson>>
}
