package hu.ujszaszik.characters.list.domain

import hu.ujszaszik.characters.shared.local.CharacterEntity
import hu.ujszaszik.extension.fromBase64

object CharacterGridMapper {

    fun map(entities: List<CharacterEntity>): List<CharacterGridModel> {
        return entities.map {
            CharacterGridModel(
                id = it.id,
                imageUrl = it.imageUrl.fromBase64()
            )
        }
    }
}