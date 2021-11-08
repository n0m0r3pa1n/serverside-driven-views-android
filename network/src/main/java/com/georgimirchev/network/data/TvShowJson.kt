package com.georgimirchev.network.data

import com.squareup.moshi.Json

class TvShowJson(
    @Json(name = "id") val id: String?,
    @Json(name = "titles") val titles: Map<String, String>?,
    @Json(name = "shortDescriptions") val shortDescriptions: Map<String, String>?,
    @Json(name = "brand") val provider: String?,
    @Json(name = "channelId") val channelId: Int?,
    @Json(name = "promamsId") val promamsId: String?,
    @Json(name = "images") val images: List<ImageJson>?,
    @Json(name = "genres") val genres: List<GenreJson>?,
    @Json(name = "links") val links: List<LinkJson>?,
    @Json(name = "refs") val refs: RefsJson?
)
