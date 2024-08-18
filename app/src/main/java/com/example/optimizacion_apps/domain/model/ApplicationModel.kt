package com.example.optimizacion_apps.domain.model

import android.os.Parcelable
import com.example.optimizacion_apps.database.entity.ApplicationEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApplicationModel(
    val id: Int = 0,
    val STR_NAME: String = "",
    val INT_USE_MEMORY_RAM: Int = 0,
    val INT_CPU_RESOURCE: Int = 0,
    val IS_IMPORTANT: Boolean = false
): Parcelable

fun ApplicationEntity.toDomain() = ApplicationModel(
    id,
    STR_NAME,
    INT_USE_MEMORY_RAM,
    INT_CPU_RESOURCE,
    IS_IMPORTANT
)
