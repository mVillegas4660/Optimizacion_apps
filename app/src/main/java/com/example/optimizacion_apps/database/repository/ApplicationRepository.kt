package com.example.optimizacion_apps.database.repository

import com.example.optimizacion_apps.database.dao.ApplicationDao
import com.example.optimizacion_apps.database.entity.ApplicationEntity
import javax.inject.Inject

class ApplicationRepository @Inject constructor(
    private val applicationDao: ApplicationDao
){
    suspend fun listApplicationsActividadFromDatabase  (
    ) : List<ApplicationEntity>{
        return applicationDao.getAll()
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