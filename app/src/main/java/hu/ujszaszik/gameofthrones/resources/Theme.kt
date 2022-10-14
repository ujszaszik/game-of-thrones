package hu.ujszaszik.gameofthrones.resources

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun GameOfThronesTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = Typography,
        content = content
    )
}