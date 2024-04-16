package com.example.wallstreetsentiment

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform