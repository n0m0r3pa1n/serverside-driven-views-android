package com.georgimirchev.domain.epg

import com.georgimirchev.domain.models.*
import com.georgimirchev.network.data.EpgEntryJson
import com.georgimirchev.network.data.ImageJson
import com.georgimirchev.network.data.SeasonJson
import com.georgimirchev.network.data.VasId
import java.util.*

class EpgEntryMapper {
    fun map(entry: EpgEntryJson) = EpgEntryModel(
        id = entry.id,
        title = entry.title,
        tvShowTitle = entry.tvShow?.title,
        description = entry.description,
        channelId = entry.channelId,
        start = Date(entry.startTime * 1000),
        end = Date(entry.endTime * 1000),
        images = mapImages(entry.images),
        videoSubType = entry.video?.subType,
        videoId = entry.video?.let { VasId(it.id) },
        parentalRating = entry.parentalRating?.age?.let { ParentalRatingModel(it) },
        episode = mapEpisode(entry),
        season = mapSeason(entry.season)
    )

    private fun mapSeason(season: SeasonJson?) = SeasonModel(season?.number?.takeIf { it > 0 })

    private fun mapEpisode(entry: EpgEntryJson?): EpisodeModel? {
        entry?.episode?.airdates ?: return null
        val episode = entry.episode!!

        val airdates = episode.airdates
            ?.filter { it.brand != null && it.date != null && it.channelId != null }
            ?.map { AirdateModel(BrandIdModel(it.brand!!), ChannelIdModel(it.channelId!!), Date(it.date!! * 1000)) }

        // TODO The episode information is not for all videos correctly provided from the MW yet.
        // Workaround: Filter unset or wrong values
        val number = episode.number.takeIf { it != null && it > 0 }
        val titles = episode.titles
        return EpisodeModel(airdates ?: emptyList(), number, titles)
    }

    private fun mapImages(images: List<ImageJson>?): List<ImageModel> = images
        ?.filter { isValidImage(it) }?.map { ImageModel(it.id!!, it.subType!!, it.url!!, it.copyright, null) }
        ?: emptyList()

    private fun isValidImage(image: ImageJson) =
        image.id != null && image.subType != null && image.url != null
}
