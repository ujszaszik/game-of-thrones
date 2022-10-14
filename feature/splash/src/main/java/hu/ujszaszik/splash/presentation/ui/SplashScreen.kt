package hu.ujszaszik.splash.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import hu.ujszaszik.extension.collectAsStateValue
import hu.ujszaszik.splash.presentation.viewmodel.SplashViewModel
import hu.ujszaszik.splash.resources.SplashLogo
import hu.ujszaszik.navigation.host.BackPressStrategy
import hu.ujszaszik.navigation.host.Host
import hu.ujszaszik.ui.layout.CenteredColumn

val SplashScreen = Host(
    route = "SplashScreen",
    title = "Splash Screen",
    backPressStrategy = BackPressStrategy.EXIT_APPLICATION
)

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onSplashFinished: () -> Unit
) {

    val viewModelState = viewModel.state.collectAsStateValue()

    LaunchedEffect(viewModelState) {
        viewModelState?.let { state ->
            if (!state.isLoading) {
                onSplashFinished()
            }
        }
    }

    CenteredColumn(modifier = Modifier.fillMaxSize()) {
        SplashLogo()
    }
}