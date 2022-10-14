package hu.ujszaszik.characters.shared.navigation

import androidx.navigation.NavController
import hu.ujszaszik.characters.details.domain.CharacterID
import hu.ujszaszik.characters.details.ui.CharacterDetailsScreen
import hu.ujszaszik.navigation.host.withData

class CharactersRouter(private val navController: NavController) {

    companion object {
        fun instance(navController: NavController) = CharactersRouter(navController)
    }

    fun showDetails(id: Int) {
        val characterID = CharacterID(id)
        navController.navigate(CharacterDetailsScreen.withData(characterID))
    }
}