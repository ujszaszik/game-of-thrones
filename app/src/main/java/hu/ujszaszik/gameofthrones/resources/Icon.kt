package hu.ujszaszik.gameofthrones.resources

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import hu.ujszaszik.extension.empty
import hu.ujszaszik.ui.resources.paddingDefault

@Composable
fun BackArrowIcon() {
    Icon(
        Icons.Default.ArrowBack,
        contentDescription = String.empty,
        modifier = Modifier
            .padding(paddingDefault)
            .size(appBarIconSize),
        tint = Color.White
    )
}