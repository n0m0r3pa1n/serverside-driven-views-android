package com.georgimirchev.network.data

import com.squareup.moshi.Json

class VideoJson(
    @Json(name = "id") val id: String,
    @Json(name = "titles") val titles: Map<String, String>,
    @Json(name = "shortDescriptions") val shortDescriptions: Map<String, String>?,
    @Json(name = "tvShow") val tvShow: TvShowJson?,
    @Json(name = "tvShowId") val tvShowId: String?,
    @Json(name = "clipId") var clipId: String,
    @Json(name = "streamUrl") val streamUrl: String?,
    @Json(name = "images") val images: List<ImageJson>,
    @Json(name = "duration") val duration: Long,
    @Json(name = "webExclusive") val webExclusive: Boolean,
    @Json(name = "subType") val subType: String?,
    @Json(name = "copyright") val copyright: String?,
    @Json(name = "productPlacement") val productPlacement: Boolean?,
    @Json(name = "parentalRating") val parentalRating: ParentalRatingJson?,
    @Json(name = "createdAt") val createdAt: Long?,
    @Json(name = "season") val season: SeasonJson?,
    @Json(name = "episode") val episode: EpisodeJson?,
    @Json(name = "visibilities") val visibilities: List<VisibilitiesJson>?,
    @Json(name = "links") val links: List<LinkJson>?
)
