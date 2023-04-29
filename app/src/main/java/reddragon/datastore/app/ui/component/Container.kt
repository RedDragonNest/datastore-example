package reddragon.datastore.app.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Container(
    counter: String,
    histories: List<String>,
    addCounter: () -> Unit,
    minusCounter: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Header(
                modifier = Modifier
                    .fillMaxWidth(),
                counter = counter
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                items(histories.size) { index ->
                    val history = histories[index]

                    Text(
                        text = history
                    )
                }
            }

            Footer(
                addCounter = addCounter,
                minusCounter = minusCounter
            )
        }
    }
}

@Composable
@Preview
private fun ContainerPreview() {
    val histories = listOf(
        "plus count and save DataStore",
        "minus count and save DataStore",
        "plus count and save DataStore",
        "minus count and save DataStore"
    )

    Container(
        counter = "0",
        histories = histories,
        addCounter = {},
        minusCounter = {}
    )
}