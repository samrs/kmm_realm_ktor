package com.example.kmm_realm_ktor

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform