package de.maxdobler.systemicconsensus

import android.app.Application
import de.maxdobler.systemicconsensus.di.AndroidModule
import de.maxdobler.systemicconsensus.di.DaggerAppComponent


class MyApplication : Application() {

    val component by lazy {
        DaggerAppComponent.builder()
                .androidModule(AndroidModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}