package de.maxdobler.systemicconsensus.group

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert


@Dao
interface GroupDao {

    @Insert
    fun insert(group: Group)

    //@Query("SELECT * FROM group")
    //fun getAll()
}