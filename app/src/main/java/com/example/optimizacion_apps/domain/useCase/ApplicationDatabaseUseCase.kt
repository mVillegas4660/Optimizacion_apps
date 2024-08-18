package com.example.optimizacion_apps.domain.useCase

import com.example.optimizacion_apps.database.entity.ApplicationEntity
import com.example.optimizacion_apps.database.repository.ApplicationRepository
import javax.inject.Inject

class ApplicationDatabaseUseCase @Inject constructor(
    val repository: ApplicationRepository
) {
    suspend fun list() : List<ApplicationEntity> {
        return repository.listApplicationsActividadFromDatabase()
    }

    suspend fun add( body : ApplicationEntity) {
        return repository.insertApplicationActividadFromDatabase(body)
    }
    suspend fun count(): Int {
        return repository.countApplicationsActividadFromDatabase()
    }

    suspend fun deleteAll() {
        return repository.deleteAllApplicationsActividadFromDatabase()
    }
}