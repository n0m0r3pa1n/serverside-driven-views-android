package com.georgimirchev.network.data.designsystem

import com.squareup.moshi.Json

class DesignDataJson(
        @Json( name = "colors") val colors: DesignDataColorJson?,
        @Json( name = "elevation") val elevation: DesignDataElevationJson?,
        @Json( name = "typography") val typography: DesignDataTypographyJson?
)
