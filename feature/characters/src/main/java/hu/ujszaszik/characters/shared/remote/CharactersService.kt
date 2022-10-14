package hu.ujszaszik.characters.shared.remote

import hu.ujszaszik.data.remote.WebService
import javax.inject.Inject

class CharactersService @Inject constructor(private val webService: WebService) {

    suspend fun getAll(): List<CharacterResponse> {
        return webService.get(CHARACTERS_PATH)
    }

    companion object {
        private const val CHARACTERS_PATH = "Characters"
    }
}