package de.maxdobler.systemicconsensus.di

import android.app.Application
import android.content.Context
import dagger.Component
import de.maxdobler.systemicconsensus.AppDatabase
import de.maxdobler.systemicconsensus.team.TeamDao
import de.maxdobler.systemicconsensus.team.TeamViewModel
import javax.inject.Singleton

@Component(
        modules = arrayOf(
                DatabaseModule::class,
                AndroidModule::class
        )
)
@Singleton
interface AppComponent {
    fun app(): Application
    fun context(): Context
    fun database(): AppDatabase
    fun teamDao(): TeamDao

    fun inject(into: TeamViewModel)
}