package de.maxdobler.systemicconsensus.team

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import de.maxdobler.systemicconsensus.AppDatabase
import de.maxdobler.systemicconsensus.MyApplication
import javax.inject.Inject


class TeamViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var db: AppDatabase

    var teams: LiveData<List<Team>> = MutableLiveData()

    init {
        (application as MyApplication).component.inject(this)
        teams = db.teamDao.loadAll()
    }

    fun createNewGroup(name: String) {
        Thread {
            db.teamDao.insert(Team(name));
        }

    }
}