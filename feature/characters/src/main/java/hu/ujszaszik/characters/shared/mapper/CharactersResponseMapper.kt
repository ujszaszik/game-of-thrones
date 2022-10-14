package hu.ujszaszik.characters.shared.mapper

import hu.ujszaszik.characters.shared.local.CharacterEntity
import hu.ujszaszik.characters.shared.remote.CharacterResponse
import hu.ujszaszik.data.mapper.CollectionMapper
import hu.ujszaszik.extension.toBase64

object CharactersResponseMapper : CollectionMapper<CharacterResponse, CharacterEntity> {

    override fun map(remote: Collection<CharacterResponse>): List<CharacterEntity> {
        return remote.map {
            CharacterEntity(
                id = it.id,
                firstName = it.firstName,
                lastName = it.lastName,
                title = it.title,
                family = it.family,
                imageUrl = it.imageUrl.toBase64()
            )
        }
    }
}