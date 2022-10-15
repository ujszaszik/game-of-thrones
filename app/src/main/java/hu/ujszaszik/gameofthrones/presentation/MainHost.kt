package hu.ujszaszik.gameofthrones.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import hu.ujszaszik.extension.empty
import hu.ujszaszik.gameofthrones.navigation.ApplicationGraph
import hu.ujszaszik.gameofthrones.navigation.LocalRouter
import hu.ujszaszik.navigation.host.*

@Composable
fun MainHost() {

    val router = LocalRouter.current

    var host by remember { mutableStateOf<Host?>(null) }

    router.onDestinationChanged { host = it.label.toString().extractHost() }

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding(),
        topBar = {
            MainAppBar(
                title = host?.title ?: String.empty,
                isVisible = host.showTopAppBar(),
                showBackArrow = host.isSubHost(),
                onBackArrowClick = { router.up() }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .imePadding()
            ) {
                BackHandler {
                    when (host?.backPressStrategy) {
                        BackPressStrategy.POP_BACKSTACK -> router.pop()
                        else -> Unit
                    }
                }
                ApplicationGraph()
            }
        },
    )
}