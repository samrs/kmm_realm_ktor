package com.example.kmm_realm_ktor.data.remote.apiservice

import com.example.kmm_realm_ktor.data.remote.models.SpacexLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class SpacexApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                }
            )
        }
    }

    suspend fun getAllLaunches(): List<SpacexLaunch> {
        return httpClient.get("https://api.spacexdata.com/v5/launches").body()
    }
}