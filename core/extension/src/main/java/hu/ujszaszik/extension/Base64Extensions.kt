package hu.ujszaszik.extension

import android.util.Base64

fun String.toBase64(): String {
    val data = toByteArray(Charsets.UTF_8)
    return Base64.encodeToString(data, Base64.NO_WRAP)
}

fun String.fromBase64(): String {
    val data: ByteArray = Base64.decode(this, Base64.NO_WRAP)
    return String(data, Charsets.UTF_8)
}