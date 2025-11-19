package com.chmelik.cmp_workshop

expect class Storage {
    fun getBool(key: String): Boolean
    fun setBool(value: Boolean, key: String)
}
