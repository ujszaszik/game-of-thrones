package hu.ujszaszik.ui.layout

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.ujszaszik.ui.resources.paddingDefault
import hu.ujszaszik.ui.resources.paddingHalf
import hu.ujszaszik.ui.resources.paddingLarge

@Composable
fun DefaultSpacer() {
    Spacer(modifier = Modifier.height(paddingDefault))
}

@Composable
fun HalfSpacer() {
    Spacer(modifier = Modifier.height(paddingHalf))
}

@Composable
fun LargeSpacer() {
    Spacer(modifier = Modifier.height(paddingLarge))
}