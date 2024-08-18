package com.example.optimizacion_apps.common

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import es.dmoral.toasty.Toasty

object MessageUtil {

    private lateinit var toasty: Toast

    fun showToast(context: Context, option: Int, message: String, timeup: Int){
        val lenght: Int = if(timeup==0) Toast.LENGTH_SHORT else Toast.LENGTH_LONG

        when(option){
            0 -> {
                toasty = Toasty.normal(context, message)
            }
            1 -> {
                toasty = Toasty.success(context, message, lenght, true)
            }
            2 -> {
                toasty = Toasty.info(context, message, lenght, true)
            }
            3 -> {
                toasty = Toasty.error(context, message, lenght, true)
            }
            4 -> {
                toasty = Toasty.warning(context, message, lenght, true)
            }
        }
        toasty.show()
        cancelToast(toasty, timeup)
    }

    private fun cancelToast(toasty: Toast, timeup: Int ){
        if( timeup == 0 ){
            // Desaparecer el Toasty después de 1 segundo
            Handler(Looper.getMainLooper()).postDelayed({
                toasty.cancel()
            }, 1250) // 1250 ms = 1 1/4 segundo
        }
    }
}