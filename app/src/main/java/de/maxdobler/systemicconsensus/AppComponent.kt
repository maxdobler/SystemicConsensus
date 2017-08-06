package de.maxdobler.systemicconsensus

import android.app.Application
import android.content.Context
import dagger.Component
import de.maxdobler.systemicconsensus.group.NewGroupViewModel
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

    fun inject(into: NewGroupViewModel)
}