package com.georgimirchev.network.data

import com.squareup.moshi.Json

data class LinkJson(
    @Json(name = "url") val url: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "product") val product: String?
)
