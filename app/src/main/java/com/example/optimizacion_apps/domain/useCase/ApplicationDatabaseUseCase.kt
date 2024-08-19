package com.example.optimizacion_apps.domain.useCase

import com.example.optimizacion_apps.database.entity.ApplicationEntity
import com.example.optimizacion_apps.database.repository.ApplicationRepository
import com.example.optimizacion_apps.domain.model.ApplicationModel
import com.example.optimizacion_apps.domain.model.toDomain
import javax.inject.Inject

class ApplicationDatabaseUseCase @Inject constructor(
    val repository: ApplicationRepository
) {
    suspend fun listAll() : List<ApplicationModel> {
        return repository.listAllApplicationsActividadFromDatabase()
    }

    suspend fun add( body : ApplicationEntity): Long {
        return repository.insertApplicationActividadFromDatabase(body)
    }

    suspend fun count(): Int {
        return repository.countApplicationsActividadFromDatabase()
    }

    suspend fun deleteAll() {
        return repository.deleteAllApplicationsActividadFromDatabase()
    }
}