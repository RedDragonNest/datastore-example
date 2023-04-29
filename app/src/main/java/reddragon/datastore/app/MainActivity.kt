package reddragon.datastore.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dagger.hilt.android.AndroidEntryPoint
import reddragon.datastore.app.ui.component.Container
import reddragon.datastore.app.ui.theme.AppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                initView()
            }
        }
    }

    @Composable
    private fun initView() {
        val counter by vm.counter.collectAsState()
        val histories by vm.histories.collectAsState()

        Container(
            counter = counter.toString(),
            histories = histories,
            addCounter = vm::addCounter,
            minusCounter = vm::minusCounter
        )
    }
}