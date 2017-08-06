package de.maxdobler.systemicconsensus

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import de.maxdobler.systemicconsensus.group.Group
import de.maxdobler.systemicconsensus.group.GroupDao


@Database(entities = arrayOf(Group::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val groupDao: GroupDao

    companion object {
        private val DB_NAME = "SystemicConsensus.db"

        fun createPersistentDatabase(context: Context): AppDatabase
                = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME).build()
    }
}