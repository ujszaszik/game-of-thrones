package hu.ujszaszik.characters.details.domain

import hu.ujszaszik.characters.shared.repository.CharactersRepository
import hu.ujszaszik.data.resource.ResourceFlow
import hu.ujszaszik.data.resource.mapResource
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {

    operator fun invoke(id: Int): ResourceFlow<CharacterDetailModel> {
        return charactersRepository
            .getCharacterById(id)
            .mapResource { CharacterDetailsMapper.map(it) }
    }
}