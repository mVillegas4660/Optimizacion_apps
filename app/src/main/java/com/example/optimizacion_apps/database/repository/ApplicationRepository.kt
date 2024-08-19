package com.example.optimizacion_apps.database.repository

import com.example.optimizacion_apps.database.dao.ApplicationDao
import com.example.optimizacion_apps.database.entity.ApplicationEntity
import com.example.optimizacion_apps.domain.model.ApplicationModel
import com.example.optimizacion_apps.domain.model.toDomain
import javax.inject.Inject

class ApplicationRepository @Inject constructor(
    private val applicationDao: ApplicationDao
){
    suspend fun listAllApplicationsActividadFromDatabase(): List<ApplicationModel> {
        val list: List<ApplicationEntity> = applicationDao.getAll()
        return list.map { it.toDomain() }
    }

    suspend fun insertApplicationActividadFromDatabase (
        body: ApplicationEntity
    ): Long {
        return applicationDao.insert(body)
    }

    suspend fun countApplicationsActividadFromDatabase  (
    ): Int {
        return applicationDao.countAll()
    }

    suspend fun deleteAllApplicationsActividadFromDatabase () {
        applicationDao.deleteAll()
    }
}