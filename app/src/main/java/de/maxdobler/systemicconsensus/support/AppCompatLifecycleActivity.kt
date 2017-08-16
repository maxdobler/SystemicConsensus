package de.maxdobler.systemicconsensus.support

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v7.app.AppCompatActivity


abstract class AppCompatLifecycleActivity : AppCompatActivity(), LifecycleRegistryOwner {
    private val mRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return mRegistry
    }

}
