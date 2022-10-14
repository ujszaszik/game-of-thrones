package hu.ujszaszik.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LoadingBox(
    modifier: Modifier = Modifier.fillMaxSize(),
    isLoading: Boolean,
    type: ProgressType = ProgressType.REPLACE_SCREEN,
    content: @Composable BoxScope.() -> Unit
) {

    val aboveScreen = type == ProgressType.ABOVE_SCREEN

    Box(
        modifier = modifier.background(if (aboveScreen) Color.Transparent else Color.White)
    ) {
        content()

        if (isLoading) {
            CenteredColumn(
                modifier = modifier.background(if (aboveScreen) Color.Transparent else Color.White)
            ) { CircularProgressIndicator() }
        }
    }
}

enum class ProgressType {
    ABOVE_SCREEN, REPLACE_SCREEN
}