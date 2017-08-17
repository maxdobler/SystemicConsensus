package de.maxdobler.systemicconsensus.team

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import de.maxdobler.systemicconsensus.MyApplication
import org.jetbrains.anko.doAsync
import javax.inject.Inject


class TeamViewModel constructor(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var teamDao: TeamDao

    var teams: LiveData<List<Team>> = MutableLiveData()

    init {
        (application as MyApplication).component.inject(this)
        teams = teamDao.loadAll()
    }

    fun createNewGroup(name: String) {
        doAsync {
            teamDao.insert(Team(name))
        }
    }
}