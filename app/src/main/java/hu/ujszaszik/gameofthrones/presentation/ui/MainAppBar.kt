package hu.ujszaszik.gameofthrones.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import hu.ujszaszik.gameofthrones.resources.BackArrowIcon
import hu.ujszaszik.gameofthrones.resources.Typography
import hu.ujszaszik.gameofthrones.resources.appBarIconContentHeight
import hu.ujszaszik.gameofthrones.resources.appBarIconContentWidth

@Composable
fun MainAppBar(
    title: String,
    isVisible: Boolean,
    showBackArrow: Boolean,
    onBackArrowClick: () -> Unit
) {
    AnimatedVisibility(visible = isVisible) {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = Typography.caption
                )
            }, // Title
            navigationIcon = {
                if (showBackArrow) {
                    IconButton(onClick = { onBackArrowClick() }) {
                        BackArrowIcon()
                    }
                }
            }, // NavigationIcon
            actions = {
                Box(
                    modifier = Modifier.size(
                        width = appBarIconContentWidth,
                        height = appBarIconContentHeight
                    ),
                    contentAlignment = Alignment.Center
                ) {}
            }, // Empty actions, needed only for title symmetry purpose
            backgroundColor = Color.Black
        )
    }
}