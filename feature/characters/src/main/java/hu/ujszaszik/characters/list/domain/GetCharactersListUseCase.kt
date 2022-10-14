package hu.ujszaszik.characters.list.domain

import hu.ujszaszik.characters.shared.repository.CharactersRepository
import hu.ujszaszik.data.resource.ResourceFlow
import hu.ujszaszik.data.resource.mapResource
import javax.inject.Inject

class GetCharactersListUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {

    operator fun invoke(): ResourceFlow<List<CharacterGridModel>> {
        return charactersRepository
            .getAllCharacters()
            .mapResource { CharacterGridMapper.map(it) }
    }
}