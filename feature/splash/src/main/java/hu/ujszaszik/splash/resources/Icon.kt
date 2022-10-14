package hu.ujszaszik.splash.resources

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import hu.ujszaszik.splash.R
import hu.ujszaszik.ui.density.dp

@Composable
fun SplashLogo() {
    Image(
        modifier = Modifier.size(splashLogoSize.dp()),
        painter = painterResource(R.drawable.logo_game_of_thrones),
        contentDescription = SPLASH_LOGO_DESCRIPTION
    )
}