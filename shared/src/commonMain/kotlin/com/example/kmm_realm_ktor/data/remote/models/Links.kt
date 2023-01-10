package com.example.kmm_realm_ktor.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("article")
    val article: String? = null,
    @SerialName("flickr")
    val flickr: Flickr? = null,
    @SerialName("patch")
    val patch: Patch? = null,
    @SerialName("presskit")
    val presskit: String? = null,
    @SerialName("reddit")
    val reddit: Reddit? = null,
    @SerialName("webcast")
    val webcast: String? = null,
    @SerialName("wikipedia")
    val wikipedia: String? = null,
    @SerialName("youtube_id")
    val youtubeId: String? = null
)