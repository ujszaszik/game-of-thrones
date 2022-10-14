package hu.ujszaszik.characters.details.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import hu.ujszaszik.characters.details.domain.GetCharacterByIdUseCase
import hu.ujszaszik.data.resource.ResourceFlowMediator
import hu.ujszaszik.reducer.ReducerViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) :
    ReducerViewModel<CharactersDetailsState, CharactersDetailsEvent>() {

    override val reducer = CharactersListReducer(CharactersDetailsState())

    internal fun loadCharacterDetails(id: Int) {
        ResourceFlowMediator(
            source = getCharacterByIdUseCase(id),
            viewModel = this,
            loadEvent = { CharactersDetailsEvent.Loading },
            successEvent = { CharactersDetailsEvent.ShowCharacterDetails(it) },
            errorEvent = { CharactersDetailsEvent.FailedToLoad }
        ).begin()
    }
}