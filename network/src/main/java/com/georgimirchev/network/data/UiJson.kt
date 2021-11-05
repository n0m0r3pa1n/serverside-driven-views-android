package com.georgimirchev.network.data

import com.georgimirchev.network.data.designsystem.DesignDataJson
import com.squareup.moshi.Json

class UiJson(
    @Json(name = "envelope") val envelope: ComponentJson?,
    @Json(name = "components") val components: ComponentWrapperJson
)

class ComponentWrapperJson(
    @Json(name = "main") val main: List<ComponentJson>,
    @Json(name = "stage") val stage: List<StageJson>?
)

class ComponentJson(
    @Json(name = "displayName") val displayName: String,
    @Json(name = "type") val type: String,
    @Json(name = "layout") val layout: String?,
    @Json(name = "cellType") val cellType: String?,
    @Json(name = "feedUrl") val feedUrl: String?,
    @Json(name = "secondaryFeedUrl") val secondaryFeedUrl: String?,
    @Json(name = "imageUrlAndroid") val image: String?,
    @Json(name = "imageUrl") val imageUrl: String?,
    @Json(name = "candidates") val candidates: List<CandidateJson>?,
    @Json(name = "teams") val teams: List<TeamJson>?,
    @Json(name = "isExternalContent") val isExternalContent: Boolean?,
    @Json(name = "minWatchPercentage") val minWatchPercentage: String?,
    @Json(name = "experimentId") val experimentId: String?,
    @Json(name = "seasonsFeedUrl") val seasonsFeedUrl: String?,
    @Json(name = "seasonVideosFeedUrl") val seasonVideosFeedUrl: String?,
    @Json(name = "noResultsMessage") val noResultsMessage: String?,
    @Json(name = "laneType") val laneType: String?,
    @Json(name = "designData") val designData: DesignDataJson?
)

class StageJson(
    @Json(name = "type") val type: String,
    @Json(name = "dataSource") val dataSource: StageDataSourceJson?
)

class StageDataSourceJson(
    @Json(name = "feedUrl") val feedUrl: String,
    @Json(name = "splitResponse") val splitResponse: Int?,
    @Json(name = "combineWith") val nestedSourceToCombineWith: StageDataSourceJson?
)

class CandidateJson(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String?,
    @Json(name = "taxonomyId") val taxonomyId: String?,
    @Json(name = "attributes") val attributes: Map<String, String>?
)

class TeamJson(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String?,
    @Json(name = "taxonomyId") val taxonomyId: String?,
    @Json(name = "attributes") val attributes: Map<String, String>?
)

