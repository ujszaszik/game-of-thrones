package hu.ujszaszik.gameofthrones.presentation.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import hu.ujszaszik.reducer.ReducerViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ReducerViewModel<MainState, MainEvent>() {

    override val reducer = MainReducer(MainState())

    internal fun onExitRequested() = reducer.sendEvent(MainEvent.ExitRequested)

    internal fun resetState() = reducer.sendEvent(MainEvent.ResetState)
}