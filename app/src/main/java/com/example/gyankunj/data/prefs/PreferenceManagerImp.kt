package com.example.gyankunj.data.prefs

import android.content.SharedPreferences
import androidx.core.content.edit

open class PreferenceManagerImp(private val prefs:SharedPreferences):PreferenceManager{



    /**
     * Puts a key-value pair in shared prefs if doesn't exists,
     * otherwise updates value on given [key]
     */
    operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> prefs.edit {
                putString(key, value)
            }
            is Int -> prefs.edit {
                putInt(key, value)
            }
            is Boolean -> prefs.edit {
                putBoolean(key, value)
            }
            is Float -> prefs.edit {
                putFloat(key, value)
            }
            is Long -> prefs.edit {
                putLong(key, value)
            }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    /**
     * Finds value on given key.
     * [T] is the type of value
     * @param defaultValue optional default value will take following if [defaultValue] is not specified
     * null for strings,
     * false for bool and
     * -1 for numeric values (int, float, long)
     */
    inline operator fun <reified T : Any> SharedPreferences.get(
        key: String,
        defaultValue: T? = null
    ): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    override fun setNumber(isNumber: String?) {
        prefs[IS_NUMBER]=isNumber
    }

    override fun getNumber(): String? {
       return prefs[IS_NUMBER]?:""
    }

    override fun setLogged(isLogged: Boolean) {
        prefs[IS_LOGGED_IN]=isLogged
    }

    override fun getLogged(): Boolean {
       return prefs[IS_LOGGED_IN]?:false
    }

    override fun setOTP(isOTP: String?) {
        prefs[IS_OTP]=isOTP
    }

    override fun getOTP(): String? {
     return prefs[IS_OTP]?:""
    }
}