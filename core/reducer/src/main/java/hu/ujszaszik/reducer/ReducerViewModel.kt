package hu.ujszaszik.reducer

import androidx.lifecycle.ViewModel
import hu.ujszaszik.reducer.model.UiEvent
import hu.ujszaszik.reducer.model.UiState
import kotlinx.coroutines.flow.Flow

abstract class ReducerViewModel<S : UiState, E : UiEvent> : ViewModel() {

    abstract val reducer: Reducer<S, E>

    val state: Flow<S>
        get() = reducer.state

}