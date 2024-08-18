package com.example.optimizacion_apps.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.optimizacion_apps.database.entity.ApplicationEntity

@Dao
interface ApplicationDao {
    @Query("select * from TB_APPLICATION")
    suspend fun getAll(): List<ApplicationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: ApplicationEntity)

    @Query("select count(*) from TB_APPLICATION")
    suspend fun countAll(): Int

    @Query("delete from TB_APPLICATION")
    suspend fun deleteAll()
}