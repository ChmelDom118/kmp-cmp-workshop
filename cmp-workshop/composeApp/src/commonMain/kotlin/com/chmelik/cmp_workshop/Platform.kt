package com.chmelik.cmp_workshop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform