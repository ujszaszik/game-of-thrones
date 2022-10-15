package hu.ujszaszik.characters.list.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import hu.ujszaszik.characters.list.domain.CharacterGridModel
import hu.ujszaszik.characters.list.viewmodel.CharactersListViewModel
import hu.ujszaszik.characters.shared.navigation.LocalCharactersRouter
import hu.ujszaszik.extension.collectAsStateValue
import hu.ujszaszik.navigation.host.BackPressStrategy
import hu.ujszaszik.navigation.host.Host
import hu.ujszaszik.navigation.host.HostType
import hu.ujszaszik.ui.layout.LoadingBox
import hu.ujszaszik.ui.orientation.OrientationBased

val CharactersListScreen = Host(
    title = "Characters",
    route = "CharactersListScreen",
    type = HostType.MAIN,
    backPressStrategy = BackPressStrategy.NONE
)

@Composable
fun CharactersListScreen(viewModel: CharactersListViewModel = hiltViewModel()) {

    val router = LocalCharactersRouter.current

    val state = viewModel.state.collectAsStateValue()

    var listToShow by remember { mutableStateOf<List<CharacterGridModel>?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(state) {
        listToShow = state?.characters
        errorMessage = state?.errorMessage
    }

    val gridCells = OrientationBased(portrait = 2, landscape = 4)

    LoadingBox(isLoading = true == state?.isLoading) {

        errorMessage?.let { CharactersListErrorScreen(it) }

        listToShow?.let {

            LazyVerticalGrid(columns = GridCells.Fixed(gridCells)) {

                items(it, key = { it.id }) { character ->

                    CharacterGridItem(
                        model = character,
                        onClick = { router.showDetails(it) }
                    )
                }
            }
        }
    }
}