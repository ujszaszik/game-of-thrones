package hu.ujszaszik.characters.list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.ujszaszik.characters.list.domain.CharacterGridModel
import hu.ujszaszik.characters.list.resource.characterIconSize
import hu.ujszaszik.ui.density.dp
import hu.ujszaszik.ui.image.NetworkImage
import hu.ujszaszik.ui.resources.paddingDefault
import hu.ujszaszik.ui.resources.paddingHalf

@Composable
fun CharacterGridItem(
    model: CharacterGridModel,
    onClick: (Int) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingDefault)
            .clickable { onClick(model.id) },
        elevation = paddingHalf,
    ) {

        Column {
            NetworkImage(
                url = model.imageUrl,
                size = characterIconSize.dp()
            )
        }
    }

}