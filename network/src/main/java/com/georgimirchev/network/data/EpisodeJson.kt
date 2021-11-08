package com.georgimirchev.network.data

import com.squareup.moshi.Json

class EpisodeJson(
        @Json(name = "airdates") val airdates: Array<AirdateJson>? = null,
        @Json(name = "number") val number: Int?,
        @Json(name = "titles") val titles: Map<String, String>?
)
