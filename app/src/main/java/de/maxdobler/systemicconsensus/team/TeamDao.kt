package de.maxdobler.systemicconsensus.team

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


@Dao
interface TeamDao {

    @Insert
    fun insert(team: Team)

    @Query("SELECT * FROM team")
    fun loadAll(): LiveData<List<Team>>
}