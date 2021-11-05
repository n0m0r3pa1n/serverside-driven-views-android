package com.georgimirchev.network.data.designsystem

import com.squareup.moshi.Json

class DesignDataTypographyJson(
    @Json(name = "headline1") val headline1: DesignDataTypographyItemJson?,
    @Json(name = "headline2") val headline2: DesignDataTypographyItemJson?,
    @Json(name = "headline3") val headline3: DesignDataTypographyItemJson?,
    @Json(name = "headline4") val headline4: DesignDataTypographyItemJson?,
    @Json(name = "headline5") val headline5: DesignDataTypographyItemJson?,
    @Json(name = "bodySmall") val bodySmall: DesignDataTypographyItemJson?,
    @Json(name = "bodyMedium") val bodyMedium: DesignDataTypographyItemJson?,
    @Json(name = "bodyLarge") val bodyLarge: DesignDataTypographyItemJson?,
    @Json(name = "subtitleSmall") val subtitleSmall: DesignDataTypographyItemJson?,
    @Json(name = "subtitleLarge") val subtitleLarge: DesignDataTypographyItemJson?,
    @Json(name = "assistiveText") val assistiveText: DesignDataTypographyItemJson?,
    @Json(name = "overline") val overline: DesignDataTypographyItemJson?,
    @Json(name = "information") val information: DesignDataTypographyItemJson?,
    @Json(name = "buttonText") val buttonText: DesignDataTypographyItemJson?,
)
class DesignDataTypographyItemJson(
    @Json(name = "fontSize") val fontSize: Int?,
    @Json(name = "fontFamily") val fontFamily: DesignFontFamily?,
    @Json(name = "lineHeight") val lineHeight: Int?,
    @Json(name = "letterSpacing") val letterSpacing: Double?,
    @Json(name = "textTransform") val textTransform: DesignTextTransformation?
)

enum class DesignTextTransformation { uppercase, lowercase }

enum class DesignFontFamily {
    @Json(name = "Montserrat-ExtraBold")
    MONTSERRAT_EXTRA_BOLD,
    @Json(name = "Montserrat-Bold")
    MONTSERRAT_BOLD,
    @Json(name = "Montserrat-Medium")
    MONTSERRAT_MEDIUM,
    @Json(name = "Montserrat-Regular")
    MONTSERRAT_REGULAR;
}
