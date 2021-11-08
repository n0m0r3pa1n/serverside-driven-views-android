package com.georgimirchev.network.data

import com.squareup.moshi.Json

data class ImageJson(@Json(name = "id") val id: String?,
                     @Json(name = "subType") val subType: String?,
                     @Json(name = "url") val url: String?,
                     @Json(name = "copyright") val copyright: String?)
