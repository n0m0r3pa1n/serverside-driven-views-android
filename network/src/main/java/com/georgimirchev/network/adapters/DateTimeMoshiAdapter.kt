package com.georgimirchev.network.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.Instant

object DateTimeMoshiAdapter {
    @FromJson
    fun fromJson(string: String): Instant = Instant.parse(string)

    @ToJson
    fun toJson(instant: Instant): String = instant.toString()
}
