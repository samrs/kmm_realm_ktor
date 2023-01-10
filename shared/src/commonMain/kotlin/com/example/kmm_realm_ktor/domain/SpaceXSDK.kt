package com.example.kmm_realm_ktor.domain

import com.example.kmm_realm_ktor.data.local.database.DatabaseManager
import com.example.kmm_realm_ktor.data.local.database.models.Launch
import com.example.kmm_realm_ktor.data.remote.apiservice.SpacexApi
import com.example.kmm_realm_ktor.data.utils.toRocketLaunch

class SpaceXSDK {
    private val databaseManager = DatabaseManager()
    private val spacexApi = SpacexApi()

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<Launch> {
        val cachedLaunches = databaseManager.selectAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            spacexApi.getAllLaunches().let { rocketLaunches ->
                databaseManager.removeAllLaunches()
                rocketLaunches.map {
                    it.toRocketLaunch()
                }.forEach {
                    databaseManager.insertLaunch(it)
                }
                databaseManager.selectAllLaunches()
            }
        }
    }
}