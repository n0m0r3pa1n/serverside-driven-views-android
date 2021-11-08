package com.georgimirchev.network.data

import com.squareup.moshi.Json

class AirdateJson(@Json(name = "brand") val brand: String?,
                  @Json(name = "channelId") val channelId: Int?,
                  @Json(name = "date") val date: Long?)
