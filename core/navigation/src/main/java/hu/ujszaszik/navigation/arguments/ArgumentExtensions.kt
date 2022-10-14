package hu.ujszaszik.navigation.arguments

import androidx.navigation.NavBackStackEntry
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

// (1) '{'
// (2) '}'
const val PARAM_BOUND_CHARACTERS_SIZE = 2

inline fun <reified T> NavBackStackEntry.retainParam(param: String): T? {
    return try {
        arguments
            ?.getString(param)
            ?.substring(param.length + PARAM_BOUND_CHARACTERS_SIZE)
            ?.convertFromJson()
    } catch (thr: Throwable) {
        null
    }
}

inline fun <reified T> String.convertFromJson(): T? {
    return Json.decodeFromString<T>(this)
}