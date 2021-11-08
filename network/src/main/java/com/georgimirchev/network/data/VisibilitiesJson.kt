package com.georgimirchev.network.data

import com.squareup.moshi.Json

class VisibilitiesJson(
        @Json(name = "endsAt") val endsAt: Long?,
        @Json(name = "channelId") val channelId: Int?
)
