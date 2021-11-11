package com.georgimirchev.domain.models

data class ImageModel(val id: String, val type: String, val url: String, val copyright: String?, val title: String?) {

    companion object {
        private val TYPE_TEASER = "Teaser"
        private val TYPE_COVER = "cover"
        private val TYPE_COVER_BIG = "Cover Big"
        private val TYPE_COVER_VERTICAL = "Cover Hochkant"
        private val TYPE_TRANSPARENT_TV_SHOW = "Formatlogo"
        private val TYPE_IMAGE = "image"

        private val PROFILE_ORIGINAL = "original"
        private val PROFILE_16_TO_9_SMALL = "7tv-452x254"
        private val PROFILE_16_TO_9_MEDIUM = "7tv-868x488"
        private val PROFILE_16_TO_9_LARGE = "7tv-1280x720"

        private val PROFILE_31_TO_10_MEDIUM = "7tv-868x280"
        private val PROFILE_TVCA_SMART_TV_CANDIDATE = "tvca-smarttv-632x910"

        val TEASER_16_TO_9_SMALL = ImageProfile(TYPE_TEASER, PROFILE_16_TO_9_SMALL, null)
        val TEASER_16_TO_9_MEDIUM = ImageProfile(TYPE_TEASER, PROFILE_16_TO_9_MEDIUM, null)
        val TEASER_16_TO_9_LARGE = ImageProfile(TYPE_TEASER, PROFILE_16_TO_9_LARGE, null)

        val COVER_16_TO_9_MEDIUM = ImageProfile(TYPE_COVER, PROFILE_16_TO_9_MEDIUM, null)
        val COVER_16_TO_9_LARGE = ImageProfile(TYPE_COVER, PROFILE_16_TO_9_LARGE, null)

        val COVER_BIG_31_TO_10_MEDIUM = ImageProfile(TYPE_COVER_BIG, PROFILE_31_TO_10_MEDIUM, null)

        val COVER_VERTICAL = ImageProfile(TYPE_COVER_VERTICAL, PROFILE_ORIGINAL, null)

        val TV_SHOW_TRANSPARENT = ImageProfile(TYPE_TRANSPARENT_TV_SHOW, PROFILE_ORIGINAL, null)
        val TV_SHOW_TRANSPARENT_MEDIUM = ImageProfile(TYPE_TRANSPARENT_TV_SHOW, PROFILE_16_TO_9_MEDIUM, null)

        val CANDIDATE = ImageProfile(TYPE_IMAGE, PROFILE_ORIGINAL, null)

        val CANDIDATE_DEFAULT = ImageProfile(TYPE_IMAGE, PROFILE_TVCA_SMART_TV_CANDIDATE, null)
    }

    fun urlForImageProfile(profile: ImageProfile): String {
        val channelSelector = if (profile.channelId != null) "/wm:${profile.channelId}" else ""
        return "$url/profile:${profile.dimensionProfile}$channelSelector"
    }

}

data class ImageProfile(val type: String, val dimensionProfile: String, val channelId: Int?)

fun List<ImageModel>.findImageByProfile(imageProfile: ImageProfile) = this.find { it.type == imageProfile.type }

fun List<ImageModel>.getImageUrl(imageProfile: ImageProfile) =
    findImageByProfile(imageProfile)?.urlForImageProfile(imageProfile)

