package com.georgimirchev.network.data

import com.squareup.moshi.Json

data class GenreJson(@Json(name = "type") val type: String,
                     @Json(name = "title") val title: String,
                     @Json(name = "subType") val subType: String)

