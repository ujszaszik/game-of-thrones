package hu.ujszaszik.characters.list.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import hu.ujszaszik.characters.details.resources.errorScreenAnimationSize
import hu.ujszaszik.ui.R
import hu.ujszaszik.ui.density.dp
import hu.ujszaszik.ui.layout.CenteredColumn
import kotlinx.coroutines.delay

private const val EFFECT_DELAY = 300L

@Composable
fun CharactersListErrorScreen(errorMessage: String) {

    var showText by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(EFFECT_DELAY)
        showText = true
    }

    CenteredColumn(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.size(errorScreenAnimationSize.dp())) {
            val lottieSpec = LottieCompositionSpec.RawRes(R.raw.animation_error)
            val composition by rememberLottieComposition(lottieSpec)
            LottieAnimation(
                composition = composition,
                iterations = 1
            )
        }

        AnimatedVisibility(showText) {
            Text(text = errorMessage, color = Color.Black)
        }
    }
}