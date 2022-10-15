package hu.ujszaszik.gameofthrones.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.ujszaszik.gameofthrones.navigation.LocalRouter
import hu.ujszaszik.gameofthrones.navigation.Router
import hu.ujszaszik.gameofthrones.resources.GameOfThronesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            GameOfThronesTheme {
                val navController = rememberNavController()
                val router = Router(navController)

                CompositionLocalProvider(
                    LocalRouter provides router
                ) { MainHost() }
            }
        }
    }
}