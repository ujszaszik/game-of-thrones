package hu.ujszaszik.data.remote.error

import hu.ujszaszik.data.resource.Resource
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object NetworkErrorHandler {

    fun <T> process(throwable: Throwable): Resource<T> {
        val error = when (throwable) {
            is SocketTimeoutException -> NetworkError.TIMEOUT
            is UnknownHostException -> NetworkError.NO_CONNECTION
            else -> NetworkError.API_ERROR
        }
        return Resource.Error(error.message)
    }
}