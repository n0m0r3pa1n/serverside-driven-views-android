package com.georgimirchev.network.data.designsystem

import com.squareup.moshi.Json

class DesignDataColorJson(
        @Json( name = "primary") val primary: String?,
        @Json( name = "primaryVariant") val primaryVariant: String?,
        @Json( name = "secondary") val secondary: String?,
        @Json( name = "dark") val dark: String?,
        @Json( name = "bright") val bright: String?,
        @Json( name = "onDark") val onDark: String?,
        @Json( name = "onBright") val onBright: String?,
        @Json( name = "error") val error: String?,
        @Json( name = "validated") val validated: String?,
        @Json( name = "link") val link: String?,
        @Json( name = "onPrimary") val onPrimary: String?,
        @Json( name = "onPrimaryVariant") val onPrimaryVariant: String?,
        @Json( name = "onSecondary") val onSecondary: String?,
        @Json( name = "onValidated") val onValidated: String?,
        @Json( name = "onError") val onError: String?,
        @Json( name = "onSurface") val onSurface: String?,
)
