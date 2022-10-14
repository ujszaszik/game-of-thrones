package hu.ujszaszik.data.remote

import hu.ujszaszik.extension.empty
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class WebService @Inject constructor(val client: HttpClient) {

    suspend inline fun <reified T> get(
        path: String = String.empty,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): T {
        return client.get("$BASE_URL$path") { block() }
    }

    companion object {
        const val BASE_URL = "https://thronesapi.com/api/v2/"
    }
}