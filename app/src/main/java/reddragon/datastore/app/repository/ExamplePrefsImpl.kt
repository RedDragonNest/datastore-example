package reddragon.datastore.app.repository

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.firstOrNull
import reddragon.datastore.datastore.ExamplePrefs
import reddragon.datastore.datastore.utils.edit
import reddragon.datastore.datastore.utils.getValue
import javax.inject.Inject

class ExamplePrefsImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ExamplePrefs {
    private val Context.dataStore by preferencesDataStore(
        name = DATA_STORE_NAME,
        produceMigrations = { context ->
            listOf(
                SharedPreferencesMigration(context, SHARED_PREFERENCE_NAME, prefsMigrationList)
            )
        })

    override suspend fun getCount() =
        context.dataStore.data.getValue(PreferencesKeys.PREFERENCE_COUNT).firstOrNull() ?: 0

    override suspend fun putCount(value: Int) {
        context.dataStore.edit(PreferencesKeys.PREFERENCE_COUNT, value)
    }

    private object PreferencesKeys {
        val PREFERENCE_COUNT = intPreferencesKey("SHARED_PREFERENCE_COUNT")
    }

    private val prefsMigrationList = setOf(
        PreferencesKeys.PREFERENCE_COUNT.name
    )

    companion object {
        private const val DATA_STORE_NAME = "EXAMPLE_DATA_STORE"
        private const val SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_NAME"
    }
}