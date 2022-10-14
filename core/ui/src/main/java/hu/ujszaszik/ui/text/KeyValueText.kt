package hu.ujszaszik.ui.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import hu.ujszaszik.ui.layout.DefaultSpacer
import hu.ujszaszik.ui.layout.HalfSpacer

@Composable
fun KeyValueText(key: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = key,
            fontWeight = FontWeight.Bold,
        )

        HalfSpacer()

        Text(text = value)

        DefaultSpacer()

    }
}