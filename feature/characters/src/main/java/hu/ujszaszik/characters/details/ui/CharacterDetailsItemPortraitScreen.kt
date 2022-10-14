package hu.ujszaszik.characters.details.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import hu.ujszaszik.characters.details.domain.CharacterDetailModel
import hu.ujszaszik.characters.details.resources.LABEL_FAMILY
import hu.ujszaszik.characters.details.resources.LABEL_NAME
import hu.ujszaszik.characters.details.resources.LABEL_TITLE
import hu.ujszaszik.characters.details.resources.characterDetailsImageSize
import hu.ujszaszik.ui.density.dp
import hu.ujszaszik.ui.image.NetworkImage
import hu.ujszaszik.ui.layout.DefaultSpacer
import hu.ujszaszik.ui.layout.LargeSpacer
import hu.ujszaszik.ui.text.KeyValueText

@Composable
fun CharacterDetailsItemPortraitScreen(model: CharacterDetailModel) {

    NetworkImage(
        url = model.imageUrl,
        size = characterDetailsImageSize.dp()
    )

    LargeSpacer()

    KeyValueText(LABEL_NAME, model.name)

    DefaultSpacer()

    KeyValueText(LABEL_TITLE, model.title)

    DefaultSpacer()

    KeyValueText(LABEL_FAMILY, model.family)

    DefaultSpacer()
}