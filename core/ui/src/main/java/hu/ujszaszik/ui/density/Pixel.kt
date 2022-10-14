package hu.ujszaszik.ui.density

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp

data class Pixel(
    val default: Dp,
    val ldpi: Dp = default,
    val mdpi: Dp = default,
    val hdpi: Dp = default,
    val xhdpi: Dp = default,
    val xxhdpi: Dp = default,
    val xxxhdpi: Dp = default
)

@Composable
fun Pixel.dp(): Dp {
    val resources = LocalContext.current.resources
    return Density.getByValue(resources.displayMetrics.density)
        ?.let {
            when (it) {
                Density.LDPI -> ldpi
                Density.MDPI -> mdpi
                Density.HDPI -> hdpi
                Density.XHDPI -> xhdpi
                Density.XXHDPI -> xxhdpi
                Density.XXXHDPI -> xxxhdpi
            }
        } ?: default
}