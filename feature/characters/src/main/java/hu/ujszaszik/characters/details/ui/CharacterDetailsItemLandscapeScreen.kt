package hu.ujszaszik.characters.details.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.ujszaszik.characters.details.domain.CharacterDetailModel
import hu.ujszaszik.characters.details.resources.LABEL_FAMILY
import hu.ujszaszik.characters.details.resources.LABEL_NAME
import hu.ujszaszik.characters.details.resources.LABEL_TITLE
import hu.ujszaszik.characters.details.resources.characterDetailsImageSize
import hu.ujszaszik.ui.density.dp
import hu.ujszaszik.ui.image.NetworkImage
import hu.ujszaszik.ui.layout.DefaultSpacer
import hu.ujszaszik.ui.resources.paddingLarge
import hu.ujszaszik.ui.text.KeyValueText

@Composable
fun CharacterDetailsItemLandscapeScreen(model: CharacterDetailModel) {

    Row(modifier = Modifier.fillMaxWidth()) {

        Column(modifier = Modifier.weight(1f)) {
            NetworkImage(
                url = model.imageUrl,
                size = characterDetailsImageSize.dp()
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = paddingLarge)
        ) {

            KeyValueText(LABEL_NAME, model.name)

            DefaultSpacer()

            KeyValueText(LABEL_TITLE, model.title)

            DefaultSpacer()

            KeyValueText(LABEL_FAMILY, model.family)

            DefaultSpacer()
        }
    }
}