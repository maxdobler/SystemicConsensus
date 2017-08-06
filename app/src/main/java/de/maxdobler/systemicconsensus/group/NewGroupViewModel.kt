package de.maxdobler.systemicconsensus.group

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import de.maxdobler.systemicconsensus.AppDatabase
import de.maxdobler.systemicconsensus.MyApplication
import javax.inject.Inject


class NewGroupViewModel constructor(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var db: AppDatabase

    init {
        (application as MyApplication).component.inject(this)
    }

    val name: MutableLiveData<String> = MutableLiveData()
    fun createNewGroup(name: String) {
        Thread({
            db.groupDao.insert(Group(name));
        })

    }
}