package com.chmelik.kmp_workshop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform