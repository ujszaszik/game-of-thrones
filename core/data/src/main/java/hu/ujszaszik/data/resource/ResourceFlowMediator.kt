package hu.ujszaszik.data.resource

import androidx.lifecycle.viewModelScope
import hu.ujszaszik.extension.empty
import hu.ujszaszik.extension.launch
import hu.ujszaszik.reducer.ReducerViewModel
import hu.ujszaszik.reducer.model.UiEvent
import hu.ujszaszik.reducer.model.UiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn

class ResourceFlowMediator<Source, State : UiState, Event : UiEvent>(
    private val source: ResourceFlow<Source>,
    private val viewModel: ReducerViewModel<State, Event>,
    private val loadEvent: () -> Event,
    private val successEvent: (Source) -> Event,
    private val errorEvent: (String) -> Event
) {

    fun begin() {
        viewModel.launch {
            source.stateIn(
                started = SharingStarted.WhileSubscribed(STOP_TIME_OUT),
                initialValue = Resource.Loading(),
                scope = viewModel.viewModelScope
            ).collectLatest { resource ->
                when (resource) {
                    is Resource.Loading -> doOnLoading()
                    is Resource.Success -> doOnSuccess(resource)
                    is Resource.Error -> doOnError(resource)
                }
            }
        }
    }

    private fun doOnLoading() = viewModel.launch { viewModel.reducer.sendEvent(loadEvent()) }

    private fun doOnSuccess(resource: Resource.Success<Source>) {
        viewModel.launch {
            resource.data?.let {
                viewModel.reducer.sendEvent(successEvent(it))
            }
        }
    }

    private fun doOnError(resource: Resource.Error<Source>) {
        viewModel.launch {
            val errorMessage = resource.message ?: String.empty
            viewModel.reducer.sendEvent(errorEvent(errorMessage))
        }
    }

    companion object {
        private const val STOP_TIME_OUT = 5000L //ms
    }
}