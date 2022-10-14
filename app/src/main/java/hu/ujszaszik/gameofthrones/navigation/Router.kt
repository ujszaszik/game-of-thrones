package hu.ujszaszik.gameofthrones.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import hu.ujszaszik.characters.shared.navigation.CHARACTERS_GRAPH_ROUTE

val LocalRouter =
    compositionLocalOf<Router> { error("LocalComposition Router not present") }

class Router(private val navController: NavHostController) {

    val switch = Switch()

    fun onDestinationChanged(block: (NavDestination) -> Unit) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            block(destination)
        }
    }

    fun pop() = navController.popBackStack()

    fun up() = navController.navigateUp()

    fun controller() = navController

    inner class Switch {
        fun toCharactersGraph() {
            navController.navigate(CHARACTERS_GRAPH_ROUTE)
        }
    }
}