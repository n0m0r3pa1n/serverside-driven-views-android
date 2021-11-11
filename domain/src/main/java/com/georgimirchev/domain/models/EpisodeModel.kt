package com.georgimirchev.domain.models

data class EpisodeModel(
        val airdates: List<AirdateModel>,
        val number: Int?,
        val titles: Map<String, String>?) {

    fun getTitle(): String? {
        return titles?.get("default")
    }
}
