package hu.ujszaszik.splash.presentation.viewmodel

import hu.ujszaszik.reducer.Reducer
import hu.ujszaszik.reducer.model.UiEvent
import hu.ujszaszik.reducer.model.UiState
import javax.annotation.concurrent.Immutable

@Immutable
data class SplashState(
    val isLoading: Boolean = true
) : UiState

@Immutable
sealed class SplashEvent : UiEvent {
    object LoadingFinished : SplashEvent()
}

class SplashReducer(initialState: SplashState) :
    Reducer<SplashState, SplashEvent>(initialState) {

    override fun reduce(oldState: SplashState, event: SplashEvent) {
        when (event) {
            is SplashEvent.LoadingFinished -> {
                setState(oldState.copy(isLoading = false))
            }
        }
    }
}