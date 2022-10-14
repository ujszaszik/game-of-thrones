package hu.ujszaszik.characters.shared.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import hu.ujszaszik.characters.details.domain.CharacterID
import hu.ujszaszik.characters.details.ui.CHARACTER_DETAIL_ID_KEY
import hu.ujszaszik.characters.details.ui.CharacterDetailsScreen
import hu.ujszaszik.characters.list.ui.CharactersListScreen
import hu.ujszaszik.navigation.arguments.retainParam
import hu.ujszaszik.navigation.composable

const val CHARACTERS_GRAPH_ROUTE = "CharactersGraph"

@Suppress("FunctionName")
fun NavGraphBuilder.CharactersGraph(navController: NavController) {

    navigation(
        startDestination = CharactersListScreen.route,
        route = CHARACTERS_GRAPH_ROUTE
    ) {

        composable(CharactersListScreen) {
            CharactersRouterProvider(navController) {
                CharactersListScreen()
            }
        }

        composable(CharacterDetailsScreen) {
            val id = it.retainParam<CharacterID>(CHARACTER_DETAIL_ID_KEY)?.id
            CharacterDetailsScreen(id)
        }
    }

}