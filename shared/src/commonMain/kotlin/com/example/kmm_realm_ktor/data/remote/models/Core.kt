package com.example.kmm_realm_ktor.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Core(
    @SerialName("core")
    val core: String? = null,
    @SerialName("flight")
    val flight: Int? = null,
    @SerialName("gridfins")
    val gridfins: Boolean? = null,
    @SerialName("landing_attempt")
    val landingAttempt: Boolean? = null,
    @SerialName("landing_success")
    val landingSuccess: Boolean? = null,
    @SerialName("landing_type")
    val landingType: String? = null,
    @SerialName("landpad")
    val landpad: String? = null,
    @SerialName("legs")
    val legs: Boolean? = null,
    @SerialName("reused")
    val reused: Boolean? = null
)