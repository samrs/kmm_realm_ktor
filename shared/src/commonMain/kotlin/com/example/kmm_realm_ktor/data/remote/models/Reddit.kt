package com.example.kmm_realm_ktor.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reddit(
    @SerialName("campaign")
    val campaign: String? = null,
    @SerialName("launch")
    val launch: String? = null,
    @SerialName("media")
    val media: String? = null,
    @SerialName("recovery")
    val recovery: String? = null
)