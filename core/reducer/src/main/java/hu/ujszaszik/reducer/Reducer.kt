package hu.ujszaszik.reducer

import hu.ujszaszik.reducer.model.UiEvent
import hu.ujszaszik.reducer.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class Reducer<S : UiState, E : UiEvent>(initialValue: S) {

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialValue)

    val state: StateFlow<S>
        get() = _state

    fun sendEvent(event: E) {
        reduce(_state.value, event)
    }

    fun setState(newState: S) {
        _state.tryEmit(newState)
    }

    abstract fun reduce(oldState: S, event: E)
}