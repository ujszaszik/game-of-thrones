package hu.ujszaszik.navigation.host

import hu.ujszaszik.extension.empty
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

@kotlinx.serialization.Serializable
data class Host(
    var route: String,
    val title: String = String.empty,
    val type: HostType = HostType.DEFAULT,
    val backPressStrategy: BackPressStrategy = BackPressStrategy.POP_BACKSTACK
)

fun Host?.actualType(): HostType = this?.type ?: HostType.DEFAULT

fun Host?.showTopAppBar(): Boolean = this?.type?.showAppBar ?: false

fun Host?.isSubHost(): Boolean = this.actualType() == HostType.SUB

fun Host.compress(): String = Json.encodeToString(this)

fun String.extractHost(): Host? = Json.decodeFromString(this)

// path/{param}
fun Host.acceptParam(param: String): Host = apply {
    route = StringBuilder().apply {
        append(route)
        append("/{")
        append(param)
        append("}")
    }.toString()
}

inline fun <reified T> Host.withData(data: T?): String {
    return route.plus(Json.encodeToJsonElement(data))
}