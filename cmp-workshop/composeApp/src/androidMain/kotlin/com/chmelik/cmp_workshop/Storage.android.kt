package com.chmelik.cmp_workshop

import android.content.Context
import android.content.SharedPreferences

actual class Storage(
    private val context: Context
) {
    private var preferences: SharedPreferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE)

    actual fun getBool(key: String): Boolean {
        return preferences.getBoolean(key, false)
    }

    actual fun setBool(value: Boolean, key: String) {
        preferences.edit().putBoolean(key, value).apply()
    }
}
