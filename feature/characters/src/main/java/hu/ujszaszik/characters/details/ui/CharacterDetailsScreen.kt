package hu.ujszaszik.characters.details.ui

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import hu.ujszaszik.characters.details.domain.CharacterDetailModel
import hu.ujszaszik.characters.details.viewmodel.CharacterDetailsViewModel
import hu.ujszaszik.extension.collectAsStateValue
import hu.ujszaszik.navigation.host.Host
import hu.ujszaszik.navigation.host.HostType
import hu.ujszaszik.navigation.host.acceptParam
import hu.ujszaszik.ui.layout.LoadingBox

const val CHARACTER_DETAIL_ID_KEY = "CharacterDetails::id"

val CharacterDetailsScreen =
    Host(
        title = "Character Details",
        route = "CharacterDetailsScreen",
        type = HostType.SUB
    ).acceptParam(CHARACTER_DETAIL_ID_KEY)

@Composable
fun CharacterDetailsScreen(id: Int?, viewModel: CharacterDetailsViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsStateValue()

    LaunchedEffect(Unit) {
        id?.let { viewModel.loadCharacterDetails(id) }
    }

    var details by remember { mutableStateOf<CharacterDetailModel?>(null) }

    LaunchedEffect(state) {
        details = state?.character
    }

    LoadingBox(isLoading = true == state?.isLoading) {
        details?.let {
            CharacterDetailsItemScreen(it)
        }
    }
}