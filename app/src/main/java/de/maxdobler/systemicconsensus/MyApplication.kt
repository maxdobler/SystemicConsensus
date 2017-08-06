package de.maxdobler.systemicconsensus

import android.app.Application


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