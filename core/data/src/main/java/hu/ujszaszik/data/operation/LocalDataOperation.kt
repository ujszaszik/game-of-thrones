package hu.ujszaszik.data.operation

import hu.ujszaszik.data.resource.Resource
import hu.ujszaszik.data.resource.ResourceFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

inline fun <Local> localDataOperation(
    crossinline localData: () -> Flow<Local>,
): ResourceFlow<Local> = flow {
    emit(Resource.Loading())
    val flow: ResourceFlow<Local> =
        try {
            localData().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            localData().map { Resource.Error(throwable.message) }
        }
    emitAll(flow)
}.flowOn(Dispatchers.IO)