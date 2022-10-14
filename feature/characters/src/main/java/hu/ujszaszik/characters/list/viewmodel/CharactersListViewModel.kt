package hu.ujszaszik.characters.list.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import hu.ujszaszik.characters.list.domain.GetCharactersListUseCase
import hu.ujszaszik.data.resource.ResourceFlowMediator
import hu.ujszaszik.reducer.ReducerViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val getCharactersListUseCase: GetCharactersListUseCase
) :
    ReducerViewModel<CharactersListState, CharactersListEvent>() {

    override val reducer = CharactersListReducer(CharactersListState())

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        ResourceFlowMediator(
            source = getCharactersListUseCase(),
            viewModel = this,
            loadEvent = { CharactersListEvent.Loading },
            successEvent = { CharactersListEvent.ShowCharacters(it) },
            errorEvent = { CharactersListEvent.FailedToLoad(it).also { println(it.errorMessage) } }
        ).begin()
    }
}