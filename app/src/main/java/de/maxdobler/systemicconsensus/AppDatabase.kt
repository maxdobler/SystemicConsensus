package de.maxdobler.systemicconsensus

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import de.maxdobler.systemicconsensus.team.Team
import de.maxdobler.systemicconsensus.team.TeamDao


@Database(entities = arrayOf(Team::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val teamDao: TeamDao

    companion object {
        private val DB_NAME = "SystemicConsensus.db"

        fun createPersistentDatabase(context: Context): AppDatabase
                = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME).build()
    }
}