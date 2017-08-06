package de.maxdobler.systemicconsensus

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(private val app: Application) {
    @Singleton
    @Provides
    fun provideApp(): Application = app

    @Singleton
    @Provides
    fun provideContext(): Context = app.applicationContext
}