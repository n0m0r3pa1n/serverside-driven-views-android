package com.georgimirchev.network.data.designsystem

import com.squareup.moshi.Json

class DesignDataElevationJson(
        @Json(name = "level0") val level0: DesignDataElevationLevelJson?,
        @Json(name = "level1") val level1: DesignDataElevationLevelJson?,
        @Json(name = "level2") val level2: DesignDataElevationLevelJson?,
        @Json(name = "level3") val level3: DesignDataElevationLevelJson?,
        @Json(name = "level4") val level4: DesignDataElevationLevelJson?,
        @Json(name = "level6") val level6: DesignDataElevationLevelJson?,
        @Json(name = "level8") val level8: DesignDataElevationLevelJson?,
        @Json(name = "level12") val level12: DesignDataElevationLevelJson?,
        @Json(name = "level16") val level16: DesignDataElevationLevelJson?,
        @Json(name = "level24") val level24: DesignDataElevationLevelJson?,
)

class DesignDataElevationLevelJson(
        @Json(name = "color") val color: String?,
        @Json(name = "base") val base: Int?,
)
