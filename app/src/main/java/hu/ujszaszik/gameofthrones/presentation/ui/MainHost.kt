package hu.ujszaszik.gameofthrones.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import hu.ujszaszik.extension.empty
import hu.ujszaszik.gameofthrones.navigation.ApplicationGraph
import hu.ujszaszik.gameofthrones.navigation.LocalRouter
import hu.ujszaszik.gameofthrones.presentation.viewmodel.MainViewModel
import hu.ujszaszik.navigation.host.*

@Composable
fun MainHost(viewModel: MainViewModel) {

    val router = LocalRouter.current

    var host by remember { mutableStateOf<Host?>(null) }

    router.onDestinationChanged { host = it.label.toString().extractHost() }

    BackHandler(enabled = true, onBack = {
        when (host?.backPressStrategy) {
            BackPressStrategy.POP_BACKSTACK -> router.pop()
            BackPressStrategy.EXIT_APPLICATION -> viewModel.onExitRequested()
            else -> Unit
        }
    })

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
            ) { ApplicationGraph() }
        },
    )
}