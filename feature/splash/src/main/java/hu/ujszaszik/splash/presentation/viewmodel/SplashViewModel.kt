package hu.ujszaszik.splash.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.ujszaszik.reducer.ReducerViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ReducerViewModel<SplashState, SplashEvent>() {

    override val reducer = SplashReducer(SplashState())

    init {
        makeSplashDelay()
    }

    private fun makeSplashDelay() {
        viewModelScope.launch {
            delay(SPLASH_DELAY)
            reducer.sendEvent(SplashEvent.LoadingFinished)
        }
    }

    companion object {
        private const val SPLASH_DELAY = 1500L
    }
}