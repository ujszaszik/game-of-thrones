package hu.ujszaszik.gameofthrones.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import hu.ujszaszik.characters.shared.navigation.CharactersGraph
import hu.ujszaszik.splash.navigation.SPLASH_GRAPH_ROUTE
import hu.ujszaszik.splash.navigation.SplashGraph

@Composable
fun ApplicationGraph() {

    val router = LocalRouter.current

    NavHost(navController = router.controller(), startDestination = SPLASH_GRAPH_ROUTE) {

        SplashGraph { router.switch.toCharactersGraph() }

        CharactersGraph(router.controller())

    }

}