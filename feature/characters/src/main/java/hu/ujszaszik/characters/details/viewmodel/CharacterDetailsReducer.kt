package hu.ujszaszik.characters.details.viewmodel

import hu.ujszaszik.characters.details.domain.CharacterDetailModel
import hu.ujszaszik.reducer.Reducer
import hu.ujszaszik.reducer.model.UiEvent
import hu.ujszaszik.reducer.model.UiState
import javax.annotation.concurrent.Immutable

@Immutable
data class CharactersDetailsState(
    val isLoading: Boolean = true,
    val character: CharacterDetailModel? = null
) : UiState

@Immutable
sealed class CharactersDetailsEvent : UiEvent {
    object Loading : CharactersDetailsEvent()
    object FailedToLoad : CharactersDetailsEvent()
    class ShowCharacterDetails(val character: CharacterDetailModel) : CharactersDetailsEvent()
}

class CharactersDetailsReducer(initialState: CharactersDetailsState) :
    Reducer<CharactersDetailsState, CharactersDetailsEvent>(initialState) {

    override fun reduce(oldState: CharactersDetailsState, event: CharactersDetailsEvent) {
        when (event) {
            CharactersDetailsEvent.Loading -> {
                setState(oldState.copy(isLoading = true))
            }

            CharactersDetailsEvent.FailedToLoad -> {
                setState(oldState.copy(isLoading = false))
            }

            is CharactersDetailsEvent.ShowCharacterDetails -> {
                setState(oldState.copy(isLoading = false, character = event.character))
            }
        }
    }
}