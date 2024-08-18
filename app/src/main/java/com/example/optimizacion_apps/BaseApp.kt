package com.example.optimizacion_apps

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp: Application() {
    companion object {
        var idEquipo: String = ""
    }
}