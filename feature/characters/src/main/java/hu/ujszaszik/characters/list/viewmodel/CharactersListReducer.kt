package hu.ujszaszik.characters.list.viewmodel

import hu.ujszaszik.characters.list.domain.CharacterGridModel
import hu.ujszaszik.reducer.Reducer
import hu.ujszaszik.reducer.model.UiEvent
import hu.ujszaszik.reducer.model.UiState
import javax.annotation.concurrent.Immutable

@Immutable
data class CharactersListState(
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val characters: List<CharacterGridModel>? = null
) : UiState

@Immutable
sealed class CharactersListEvent : UiEvent {
    object Loading : CharactersListEvent()
    class FailedToLoad(val errorMessage: String) : CharactersListEvent()
    class ShowCharacters(val characters: List<CharacterGridModel>) : CharactersListEvent()
}

class CharactersListReducer(initialState: CharactersListState) :
    Reducer<CharactersListState, CharactersListEvent>(initialState) {

    override fun reduce(oldState: CharactersListState, event: CharactersListEvent) {
        when (event) {
            CharactersListEvent.Loading -> {
                setState(oldState.copy(isLoading = true))
            }

            is CharactersListEvent.FailedToLoad -> {
                setState(oldState.copy(isLoading = false, errorMessage = event.errorMessage))
            }

            is CharactersListEvent.ShowCharacters -> {
                setState(
                    oldState.copy(
                        isLoading = false,
                        errorMessage = null,
                        characters = event.characters
                    )
                )
            }
        }
    }
}