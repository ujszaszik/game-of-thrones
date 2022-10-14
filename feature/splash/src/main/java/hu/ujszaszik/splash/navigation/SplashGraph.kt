package hu.ujszaszik.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import hu.ujszaszik.splash.presentation.ui.SplashScreen
import hu.ujszaszik.navigation.composable

const val SPLASH_GRAPH_ROUTE = "SplashGraph"

@Suppress("FunctionName")
fun NavGraphBuilder.SplashGraph(
    onSplashFinished: () -> Unit
) {

    navigation(
        startDestination = SplashScreen.route,
        route = SPLASH_GRAPH_ROUTE
    ) {

        composable(SplashScreen) {
            SplashScreen { onSplashFinished() }
        }
    }
}