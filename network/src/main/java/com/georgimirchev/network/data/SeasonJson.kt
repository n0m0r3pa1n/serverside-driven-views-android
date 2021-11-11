package com.georgimirchev.network.data

import com.squareup.moshi.Json

class SeasonJson(
    @Json(name = "number") val number: Int?,
    @Json(name = "titles") val titles: Map<String, String>?
)
