package de.maxdobler.systemicconsensus.di

import android.content.Context
import dagger.Module
import dagger.Provides
import de.maxdobler.systemicconsensus.AppDatabase
import de.maxdobler.systemicconsensus.team.TeamDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase = AppDatabase.createPersistentDatabase(context)

    @Singleton
    @Provides
    fun provideTeamDao(db: AppDatabase): TeamDao = db.teamDao

}
