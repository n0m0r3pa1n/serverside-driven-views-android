package com.georgimirchev.domain.models

import com.georgimirchev.network.data.VasId
import java.util.*

data class EpgEntryModel(val id: String, // ID is NOT unique
                         val title: String? = null,
                         val tvShowTitle: String? = null,
                         val description: String? = null,
                         val channelId: Int,
                         val start: Date,
                         val end: Date,
                         val images: List<ImageModel> = emptyList(),
                         val videoSubType: String? = null,
                         val videoId: VasId? = null,
                         val parentalRating: ParentalRatingModel? = null,
                         val episode: EpisodeModel? = null,
                         val season: SeasonModel? = null)
