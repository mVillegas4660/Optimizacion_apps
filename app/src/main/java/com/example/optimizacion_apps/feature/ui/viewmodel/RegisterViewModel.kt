package com.example.optimizacion_apps.feature.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.optimizacion_apps.database.entity.ApplicationEntity
import com.example.optimizacion_apps.domain.useCase.ApplicationDatabaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val applicationDatabaseUseCase: ApplicationDatabaseUseCase
): ViewModel() {

    private var mIsRegister = MutableLiveData<Boolean>()
    val isRegister: LiveData<Boolean> get() = mIsRegister

    fun RegisterForm( item: ApplicationEntity ){
        viewModelScope.launch(Dispatchers.IO){
            val isRegisterResult = applicationDatabaseUseCase.add( item )
            mIsRegister.postValue( if(isRegisterResult.toInt() != 0) true else false)
        }
    }
}