package reddragon.datastore.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import reddragon.datastore.datastore.ExamplePrefs
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val examplePrefs: ExamplePrefs
) : ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter = _counter.asStateFlow()

    private val _histories: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val histories = _histories.asStateFlow()

    init {
        initCounter()
    }

    private fun initCounter() {
        viewModelScope.launch {
            _counter.value = examplePrefs.getCount()
        }
    }

    fun addCounter() {
        viewModelScope.launch {
            val counter = examplePrefs.getCount() + 1
            examplePrefs.putCount(counter)

            _counter.value = counter

            addhistories("press plus button : $counter is saved to DataStore")
        }
    }

    fun minusCounter() {
        viewModelScope.launch {
            val counter = examplePrefs.getCount() - 1
            examplePrefs.putCount(counter)

            _counter.value = counter

            addhistories("press minus button : $counter is saved to DataStore")
        }
    }

    private fun addhistories(histories: String) {
        _histories.value = _histories.value + histories
    }
}