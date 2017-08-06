package de.maxdobler.systemicconsensus

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context) = AppDatabase.createPersistentDatabase(context)

}
