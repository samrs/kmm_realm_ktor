package com.example.kmm_realm_ktor.data.local.database

import com.example.kmm_realm_ktor.data.local.database.models.Launch
import com.example.kmm_realm_ktor.data.local.database.models.RocketData
import com.example.kmm_realm_ktor.data.remote.models.old.Rocket
import com.example.kmm_realm_ktor.data.remote.models.old.RocketLaunch
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.notifications.ResultsChange
import io.realm.kotlin.query.RealmQuery
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class DatabaseManager {
    private val schemaClass = setOf(Launch::class, RocketData::class)

    private val realm by lazy {
        val config =
            RealmConfiguration.Builder(schemaClass)
                .name("appDatabase")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.open(config)
    }

    suspend fun insertLaunch(rocketLaunch: RocketLaunch) {
        realm.write {
            copyToRealm(
                Launch().apply {
                    flightNumber = rocketLaunch.flightNumber
                    missionName = rocketLaunch.missionName
                    launchYear = rocketLaunch.launchYear
                    rocketId = rocketLaunch.rocket.id
                    details = rocketLaunch.details.orEmpty()
                    launchSuccess = rocketLaunch.launchSuccess
                    launchDateUTC = rocketLaunch.launchDateUTC
                    missionPatchUrl = rocketLaunch.links.missionPatchUrl
                    articleUrl = rocketLaunch.links.articleUrl
                },
                updatePolicy = UpdatePolicy.ALL
            )
        }
    }

    suspend fun insertRocket(rocket: Rocket) {
        realm.write {
            copyToRealm(
                RocketData().apply {
                    id = rocket.id
                    name = rocket.name
                    type = rocket.type
                }
            )
        }
    }

    private fun queryRocketById(rocketId: String): RealmQuery<RocketData> {
        return realm.query<RocketData>("id == $0", rocketId)
    }

    fun selectRocketById(rocketId: String): Flow<ResultsChange<RocketData>> {
        return queryRocketById(rocketId).asFlow()
    }

    suspend fun selectRocketLaunches(rocketId: String): Flow<ResultsChange<Launch>> {
        return withContext(Dispatchers.Default) {
            val rocket = queryRocketById(rocketId).find().first()
            realm.query<Launch>("rocketId == $0", rocket.id).asFlow()
        }
    }

    suspend fun selectAllLaunches(): RealmResults<Launch> {
        return withContext(Dispatchers.Default) {
            realm.query<Launch>().find()
        }
    }

    suspend fun removeAllLaunches() {
        realm.write {
            val launches: RealmResults<Launch> = query<Launch>().find()
            delete(launches)
        }
    }

    suspend fun removeAllRockets() {
        realm.write {
            val rockets: RealmResults<RocketData> = query<RocketData>().find()
            delete(rockets)
        }
    }

    suspend fun clearAll() {
        withContext(Dispatchers.Default) {
            Realm.deleteRealm(realm.configuration)
        }
    }
}