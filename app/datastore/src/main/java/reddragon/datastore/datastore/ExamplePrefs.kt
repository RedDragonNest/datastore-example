package reddragon.datastore.datastore

interface ExamplePrefs {
    suspend fun getCount(): Int
    suspend fun putCount(value: Int)
}