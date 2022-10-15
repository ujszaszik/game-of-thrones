package hu.ujszaszik.characters.list.domain

import hu.ujszaszik.characters.shared.repository.ICharactersRepository
import hu.ujszaszik.data.resource.ResourceFlow
import hu.ujszaszik.data.resource.mapResource
import javax.inject.Inject

class GetCharactersListUseCase @Inject constructor(
    private val charactersRepository: ICharactersRepository
) {

    operator fun invoke(): ResourceFlow<List<CharacterGridModel>> {
        return charactersRepository
            .getAllCharacters()
            .mapResource { CharacterGridMapper.map(it) }
    }
}