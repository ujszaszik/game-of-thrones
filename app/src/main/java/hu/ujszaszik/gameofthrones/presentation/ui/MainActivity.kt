package hu.ujszaszik.gameofthrones.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.ujszaszik.extension.collectAsStateValue
import hu.ujszaszik.gameofthrones.navigation.LocalRouter
import hu.ujszaszik.gameofthrones.navigation.Router
import hu.ujszaszik.gameofthrones.presentation.viewmodel.MainViewModel
import hu.ujszaszik.gameofthrones.resources.GameOfThronesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            GameOfThronesTheme {
                val navController = rememberNavController()
                val router = Router(navController)

                val state = viewModel.state.collectAsStateValue()
                LaunchedEffect(state) {
                    if (true == state?.isExitRequested) {
                        viewModel.resetState()
                        finishAffinity()
                    }
                }

                CompositionLocalProvider(
                    LocalRouter provides router
                ) { MainHost(viewModel) }
            }
        }
    }
}