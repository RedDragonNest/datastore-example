package reddragon.datastore.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import reddragon.datastore.app.repository.ExamplePrefsImpl
import reddragon.datastore.datastore.ExamplePrefs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractExamplePrefs {
    @Binds
    @Singleton
    abstract fun bindExamplePrefs(
        impl: ExamplePrefsImpl
    ): ExamplePrefs
}