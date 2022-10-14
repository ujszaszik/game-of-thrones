package hu.ujszaszik.characters.details.domain

import hu.ujszaszik.characters.shared.local.CharacterEntity
import hu.ujszaszik.extension.fromBase64

object CharacterDetailsMapper {

    fun map(entity: CharacterEntity): CharacterDetailModel {
        return CharacterDetailModel(
            name = "${entity.firstName} ${entity.lastName}",
            title = entity.title,
            family = entity.family,
            imageUrl = entity.imageUrl.fromBase64()
        )
    }
}