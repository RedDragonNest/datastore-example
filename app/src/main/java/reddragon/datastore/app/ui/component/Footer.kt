package reddragon.datastore.app.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Footer(
    addCounter: () -> Unit,
    minusCounter: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        CustomButton(
            text = "-",
            onClick = minusCounter
        )

        CustomButton(
            text = "+",
            onClick = addCounter
        )
    }
}

@Composable
@Preview
private fun FooterPreview() {
    Footer(
        addCounter = {},
        minusCounter = {}
    )
}