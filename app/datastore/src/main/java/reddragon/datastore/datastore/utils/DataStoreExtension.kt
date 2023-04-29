package reddragon.datastore.datastore.utils

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

suspend fun FlowCollector<Preferences>.recoverOrThrow(throwable: Throwable) {
    Log.d("DATA_STORE_EXTENSION", "recover or throw : $throwable")
    emit(emptyPreferences())
}

@JvmName("editInt")
suspend fun DataStore<Preferences>.edit(key: Preferences.Key<Int>, value: Int) {
    edit { preferences ->
        preferences[key] = value
    }
}

@JvmName("getInt")
fun Flow<Preferences>.getValue(key: Preferences.Key<Int>) =
    catch {
        recoverOrThrow(it)
    }.map { preferences ->
        preferences[key]
    }