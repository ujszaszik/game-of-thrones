package hu.ujszaszik.characters.shared.repository

import hu.ujszaszik.characters.shared.local.CharacterEntity
import hu.ujszaszik.data.resource.ResourceFlow

interface ICharactersRepository {

    fun getAllCharacters(): ResourceFlow<List<CharacterEntity>>

    fun getCharacterById(id: Int): ResourceFlow<CharacterEntity>
}