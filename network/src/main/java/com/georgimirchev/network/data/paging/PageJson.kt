package com.georgimirchev.network.data.paging

import com.squareup.moshi.Json

class PageJson<out T>(
    @Json(name = "totalCount") val totalCount: Int?,
    @Json(name = "data") val items: List<T>
)
