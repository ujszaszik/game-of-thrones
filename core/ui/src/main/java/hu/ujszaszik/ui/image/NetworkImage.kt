package hu.ujszaszik.ui.image

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import hu.ujszaszik.extension.empty
import hu.ujszaszik.ui.R

@Composable
fun NetworkImage(url: String?, size: Dp) {

    if (url != null) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .diskCacheKey(url)
                .diskCachePolicy(CachePolicy.ENABLED)
                .crossfade(true)
                .placeholder(R.drawable.ic_placeholder)
                .build(),
            contentDescription = String.empty,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(size)
        )
    } else ImagePlaceholder(size)

}