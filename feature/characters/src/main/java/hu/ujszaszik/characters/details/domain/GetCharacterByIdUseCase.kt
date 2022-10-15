package hu.ujszaszik.characters.details.domain

import hu.ujszaszik.characters.shared.repository.ICharactersRepository
import hu.ujszaszik.data.resource.ResourceFlow
import hu.ujszaszik.data.resource.mapResource
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val charactersRepository: ICharactersRepository
) {

    operator fun invoke(id: Int): ResourceFlow<CharacterDetailModel> {
        return charactersRepository
            .getCharacterById(id)
            .mapResource { CharacterDetailsMapper.map(it) }
    }
}