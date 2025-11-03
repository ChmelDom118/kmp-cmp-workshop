package com.chmelik.cmp_workshop

import platform.Foundation.NSUserDefaults

actual class Storage {
    private val userDefaults = NSUserDefaults.standardUserDefaults

    actual fun getBool(key: String): Boolean {
        return userDefaults.boolForKey(key)
    }

    actual fun setBool(value: Boolean, key: String) {
        userDefaults.setBool(value, key)
    }
}
