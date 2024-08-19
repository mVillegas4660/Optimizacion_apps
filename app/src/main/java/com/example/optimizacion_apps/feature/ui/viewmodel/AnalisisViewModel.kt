package com.example.optimizacion_apps.feature.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.optimizacion_apps.database.entity.ApplicationEntity
import com.example.optimizacion_apps.domain.model.ApplicationModel
import com.example.optimizacion_apps.domain.useCase.ApplicationDatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnalisisViewModel @Inject constructor(
    private val applicationDatabaseUseCase: ApplicationDatabaseUseCase
): ViewModel() {

    private var mlist = MutableLiveData<List<ApplicationModel>>()
    val list: LiveData<List<ApplicationModel>> get() = mlist

    fun getApplications(){
        viewModelScope.launch(Dispatchers.IO){
            val listResult = applicationDatabaseUseCase.listAll()
            mlist.postValue( listResult )
        }
    }
}