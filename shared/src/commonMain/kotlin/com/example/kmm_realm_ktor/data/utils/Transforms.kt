package com.example.kmm_realm_ktor.data.utils

import com.example.kmm_realm_ktor.data.remote.models.SpacexLaunch
import com.example.kmm_realm_ktor.data.remote.models.old.Links
import com.example.kmm_realm_ktor.data.remote.models.old.Rocket
import com.example.kmm_realm_ktor.data.remote.models.old.RocketLaunch

fun SpacexLaunch.toRocketLaunch(): RocketLaunch {
    return RocketLaunch(
        flightNumber ?: 0,
        name.orEmpty(),
        dateUnix ?: 0,
        dateUtc.orEmpty(),
        getRocket(this),
        details,
        success,
        getLinks(this)
    )
}

private fun getRocket(spacexLaunch: SpacexLaunch): Rocket {
    return Rocket(
        spacexLaunch.id.orEmpty(),
        spacexLaunch.name.orEmpty(),
        spacexLaunch.launchpad.orEmpty()
    )
}

private fun getLinks(spacexLaunch: SpacexLaunch): Links {
    return Links(
        spacexLaunch.links?.patch?.small,
        spacexLaunch.links?.reddit?.media
    )
}