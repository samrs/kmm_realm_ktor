package com.example.kmm_realm_ktor.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Patch(
    @SerialName("large")
    val large: String? = null,
    @SerialName("small")
    val small: String? = null
)