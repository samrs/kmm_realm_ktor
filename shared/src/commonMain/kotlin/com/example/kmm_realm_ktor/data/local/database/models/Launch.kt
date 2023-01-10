package com.example.kmm_realm_ktor.data.local.database.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Serializable
import org.mongodb.kbson.BsonObjectId

@Serializable
class Launch: RealmObject {
    @PrimaryKey
    var id: BsonObjectId = BsonObjectId()
    var flightNumber: Int = 0
    var missionName:String = ""
    var launchYear: Int = 0
    var rocketId: String = ""
    var details: String = ""
    var launchSuccess: Boolean? = null
    var launchDateUTC: String = ""
    var missionPatchUrl: String? = null
    var articleUrl: String? = null
}