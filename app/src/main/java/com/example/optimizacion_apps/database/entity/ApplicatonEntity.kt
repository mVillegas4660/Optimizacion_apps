package com.example.optimizacion_apps.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.optimizacion_apps.domain.model.ApplicationModel

@Entity( tableName = "TB_APPLICATION")
data class ApplicationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "STR_NAME") val STR_NAME: String = "",
    @ColumnInfo(name = "INT_USE_MEMORY_RAM") val INT_USE_MEMORY_RAM: Int = 0,
    @ColumnInfo(name = "INT_CPU_RESOURCE") val INT_CPU_RESOURCE: Int = 0,
    @ColumnInfo(name = "IS_IMPORTANT") val IS_IMPORTANT: Boolean = false
)

fun ApplicationModel.toDatabase() = ApplicationEntity(
    id,
    STR_NAME,
    INT_USE_MEMORY_RAM,
    INT_CPU_RESOURCE,
    IS_IMPORTANT
)
