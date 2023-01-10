package com.example.kmm_realm_ktor.data.local.database.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class RocketData: RealmObject {
    @PrimaryKey
    var id: String = ""
    var name: String = ""
    var type: String = ""
}