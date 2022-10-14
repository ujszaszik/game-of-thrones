package hu.ujszaszik.ui.orientation

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun <T> OrientationBased(
    portrait: T,
    landscape: T
): T {

    val configuration = LocalConfiguration.current

    return when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> landscape
        else -> portrait
    }
}