package hu.ujszaszik.ui.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import hu.ujszaszik.extension.empty
import hu.ujszaszik.ui.R

@Composable
fun ImagePlaceholder(height: Dp) {
    Image(
        painter = painterResource(R.drawable.ic_placeholder),
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        contentDescription = String.empty
    )
}