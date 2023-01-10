package com.example.kmm_realm_ktor.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Flickr(
    @SerialName("original")
    val original: List<String?>? = null,
    @SerialName("small")
    val small: List<String?>? = null
)