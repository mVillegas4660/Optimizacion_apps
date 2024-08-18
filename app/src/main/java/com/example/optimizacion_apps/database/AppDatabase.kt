package com.example.optimizacion_apps.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.optimizacion_apps.database.dao.ApplicationDao
import com.example.optimizacion_apps.database.entity.ApplicationEntity

@Database(
    entities =
        [
            ApplicationEntity::class
        ], version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getApplicationDao(): ApplicationDao
}