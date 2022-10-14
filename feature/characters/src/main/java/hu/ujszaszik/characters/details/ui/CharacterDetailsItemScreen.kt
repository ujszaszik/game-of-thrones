package hu.ujszaszik.characters.details.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.ujszaszik.characters.details.domain.CharacterDetailModel
import hu.ujszaszik.ui.layout.DefaultSpacer
import hu.ujszaszik.ui.layout.TopCenterColumn
import hu.ujszaszik.ui.orientation.OrientationAware
import hu.ujszaszik.ui.resources.paddingDouble

@Composable
fun CharacterDetailsItemScreen(model: CharacterDetailModel) {

    TopCenterColumn(
        modifier = Modifier
            .padding(paddingDouble)
            .verticalScroll(rememberScrollState())
    ) {

        DefaultSpacer()

        OrientationAware(
            portrait = { CharacterDetailsItemPortraitScreen(model) },
            landscape = { CharacterDetailsItemLandscapeScreen(model) }
        )
    }
}