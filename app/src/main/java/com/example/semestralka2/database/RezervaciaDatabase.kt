package com.example.semestralka2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DostupnyPodnik::class, MojaRezervacia::class], version = 1)
abstract class RezervaciaDatabase : RoomDatabase() {
    abstract fun rezervaciaDao(): RezervaciaDao

    companion object {
        @Volatile
        private var INSTANCE: RezervaciaDatabase? = null
        fun getInstance(context: Context): RezervaciaDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    RezervaciaDatabase::class.java, "rezervacia_database"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build()
                    .also { INSTANCE = it }
            }

        }
    }
}