package com.example.kmm_realm_ktor.data.remote.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class SpacexLaunch(
    @SerialName("auto_update")
    val autoUpdate: Boolean? = null,
    @SerialName("cores")
    val cores: List<Core?>? = null,
    @SerialName("date_local")
    val dateLocal: String? = null,
    @SerialName("date_precision")
    val datePrecision: String? = null,
    @SerialName("date_unix")
    val dateUnix: Int? = null,
    @SerialName("date_utc")
    val dateUtc: String? = null,
    @SerialName("details")
    val details: String? = null,
    @SerialName("flight_number")
    val flightNumber: Int? = null,
    @SerialName("id")
    val id: String? = null,
    @SerialName("launchpad")
    val launchpad: String? = null,
    @SerialName("links")
    val links: Links? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("net")
    val net: Boolean? = null,
    @SerialName("rocket")
    val rocket: String? = null,
    @SerialName("static_fire_date_unix")
    val staticFireDateUnix: Int? = null,
    @SerialName("static_fire_date_utc")
    val staticFireDateUtc: String? = null,
    @SerialName("success")
    val success: Boolean? = null,
    @SerialName("tdb")
    val tdb: Boolean? = null,
    @SerialName("upcoming")
    val upcoming: Boolean? = null,
    @SerialName("window")
    val window: Int? = null
)