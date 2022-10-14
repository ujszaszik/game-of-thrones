package hu.ujszaszik.gameofthrones.presentation.viewmodel

import hu.ujszaszik.reducer.Reducer
import hu.ujszaszik.reducer.model.UiEvent
import hu.ujszaszik.reducer.model.UiState
import javax.annotation.concurrent.Immutable

@Immutable
data class MainState(val isExitRequested: Boolean = false) : UiState

@Immutable
sealed class MainEvent : UiEvent {
    object ExitRequested : MainEvent()
    object ResetState : MainEvent()
}

class MainReducer(initialState: MainState) : Reducer<MainState, MainEvent>(initialState) {

    override fun reduce(oldState: MainState, event: MainEvent) {
        when (event) {

            is MainEvent.ExitRequested -> {
                setState(oldState.copy(isExitRequested = true))
            }

            is MainEvent.ResetState -> {
                setState(MainState())
            }

        }
    }
}