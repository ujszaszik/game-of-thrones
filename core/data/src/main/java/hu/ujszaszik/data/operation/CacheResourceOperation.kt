package hu.ujszaszik.data.operation

import hu.ujszaszik.data.remote.NetworkMonitor
import hu.ujszaszik.data.remote.error.NetworkError
import hu.ujszaszik.data.remote.error.NetworkErrorHandler
import hu.ujszaszik.data.resource.Resource
import hu.ujszaszik.data.resource.ResourceFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

inline fun <Remote, Local> cacheResourceOperation(
    crossinline cachedData: suspend () -> Flow<Local>,
    crossinline remoteCall: suspend () -> Remote,
    crossinline saveResult: suspend (Local) -> Unit,
    crossinline mapper: (Remote) -> Local,
    crossinline shouldFetch: (Local) -> Boolean = { true }
): ResourceFlow<Local> = flow {
    val data = cachedData().first()

    val flow: ResourceFlow<Local> =

        if (shouldFetch(data)) {

            if (!NetworkMonitor.isConnected()) {
                cachedData().map { Resource.Error(NetworkError.NO_CONNECTION.message) }
            } else {
                // has internet connection
                emit(Resource.Loading())
                try {
                    saveResult(mapper(remoteCall()))
                    cachedData().map { Resource.Success(it) }
                } catch (throwable: Throwable) {
                    cachedData().map { NetworkErrorHandler.process(throwable) }
                }
            }
        } else {
            // data is already fetched from network
            cachedData().map { Resource.Success(it) }
        }

    emitAll(flow)

}.flowOn(Dispatchers.IO)