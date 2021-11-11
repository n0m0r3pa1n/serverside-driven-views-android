package com.georgimirchev.network.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class EpgEntryJson(
    @Json(name = "id") val id: String,
    @Json(name = "title") val title: String? = null,
    @Json(name = "description") val description: String? = null,
    @Json(name = "channelId") val channelId: Int,
    @Json(name = "images") val images: List<ImageJson> = emptyList(),
    @Json(name = "startTime") val startTime: Long,
    @Json(name = "endTime") val endTime: Long,
    @Json(name = "tvShow") val tvShow: TvShowJson? = null,
    @Json(name = "video") val video: VideoJson? = null,
    @Json(name = "videoId") val videoId: VasId? = null,
    @Json(name = "parentalRating") val parentalRating: ParentalRatingJson? = null,
    @Json(name = "season") val season: SeasonJson? = null,
    @Json(name = "episode") val episode: EpisodeJson? = null
) {

    @JsonClass(generateAdapter = true)
    class TvShowJson(@Json(name = "title") val title: String)

    @JsonClass(generateAdapter = true)
    class VideoJson(@Json(name = "subType") val subType: String,
                    @Json(name = "id") val id: String)
}
