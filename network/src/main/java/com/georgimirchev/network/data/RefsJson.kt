package com.georgimirchev.network.data

import com.squareup.moshi.Json

data class RefsJson(@Json( name = "previewVideo") val previewVideo: PreviewVideoJson) {
    class PreviewVideoJson(@Json( name = "id") val id: String)
}
