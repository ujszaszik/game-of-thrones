package hu.ujszaszik.characters.shared.repository

import hu.ujszaszik.characters.shared.local.CharacterEntity
import hu.ujszaszik.characters.shared.local.CharactersDatabase
import hu.ujszaszik.characters.shared.mapper.CharactersResponseMapper
import hu.ujszaszik.characters.shared.remote.CharactersService
import hu.ujszaszik.data.operation.cacheResourceOperation
import hu.ujszaszik.data.operation.localDataOperation
import hu.ujszaszik.data.resource.ResourceFlow
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    database: CharactersDatabase,
    private val service: CharactersService,
) : ICharactersRepository {
    private val dao = database.dao()

    override fun getAllCharacters(): ResourceFlow<List<CharacterEntity>> {
        return cacheResourceOperation(
            cachedData = { dao.getAll() },
            remoteCall = { service.getAll() },
            saveResult = { dao.insertAll(it) },
            mapper = { CharactersResponseMapper.map(it) },
            shouldFetch = { dao.isEmpty() }
        )
    }

    override fun getCharacterById(id: Int): ResourceFlow<CharacterEntity> {
        return localDataOperation { dao.getById(id) }
    }
}