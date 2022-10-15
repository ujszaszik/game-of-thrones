package hu.ujszaszik.characters.shared.repository

import hu.ujszaszik.characters.shared.local.CharacterEntity
import hu.ujszaszik.data.resource.Resource
import hu.ujszaszik.data.resource.ResourceFlow
import kotlinx.coroutines.flow.flow

class FakeCharactersRepository(private val throwError: Boolean = false) : ICharactersRepository {

    override fun getAllCharacters(): ResourceFlow<List<CharacterEntity>> {
        return flow {
            if (throwError) emit(Resource.Error())
            else emit(Resource.Success(fakeCharacters))
        }
    }

    override fun getCharacterById(id: Int): ResourceFlow<CharacterEntity> {
        return flow {
            if (throwError) emit(Resource.Error())
            else emit(Resource.Success(fakeCharacters.first { it.id == id }))
        }
    }
}

internal val fakeCharacters = listOf(
    CharacterEntity(
        id = 1,
        firstName = "First",
        lastName = "Character",
        title = "Testing Character",
        family = "Testing Family",
        imageUrl = "aHR0cC8vdGVzdGluZy5jb20vZmlyc3QucG5n"
    ),
    CharacterEntity(
        id = 2,
        firstName = "Second",
        lastName = "Character",
        title = "Another Testing Character",
        family = "Another Testing Family",
        imageUrl = "aHR0cC8vdGVzdGluZy5jb20vc2Vjb25kLnBuZw=="
    ),
    CharacterEntity(
        id = 3,
        firstName = "Third",
        lastName = "Character",
        title = "Yet Another Testing Character",
        family = "Yet Another Testing Family",
        imageUrl = "aHR0cC8vdGVzdGluZy5jb20vdGhpcmQucG5n"
    )
)