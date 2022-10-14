package hu.ujszaszik.characters.shared.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController

val LocalCharactersRouter =
    compositionLocalOf<CharactersRouter> { error("LocalComposition CharactersRouter not present") }

@Composable
fun CharactersRouterProvider(navController: NavController, block: @Composable () -> Unit) {
    val charactersRouter = CharactersRouter.instance(navController)

    CompositionLocalProvider(LocalCharactersRouter provides charactersRouter) {
        block()
    }
}