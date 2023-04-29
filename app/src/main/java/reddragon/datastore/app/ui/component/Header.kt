package reddragon.datastore.app.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    counter: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = counter,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
@Preview
private fun HeaderPreview() {
    Header(
        counter = "0"
    )
}