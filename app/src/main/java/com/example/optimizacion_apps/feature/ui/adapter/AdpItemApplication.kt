package com.example.optimizacion_apps.feature.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.optimizacion_apps.R
import com.example.optimizacion_apps.databinding.ItemAdpApplicationBinding
import com.example.optimizacion_apps.domain.model.ApplicationModel

class AdpItemApplication (private val applicationsList: List<ApplicationModel> ): RecyclerView.Adapter<AdpItemApplication.ListApplicationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListApplicationViewHolder {
        val binding = ItemAdpApplicationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListApplicationViewHolder(binding)
    }

    override fun getItemCount(): Int = applicationsList.size

    override fun onBindViewHolder(holder: ListApplicationViewHolder, position: Int) {
        val item = applicationsList[position]
        holder.render(item)
    }

    class ListApplicationViewHolder(private val binding: ItemAdpApplicationBinding): RecyclerView.ViewHolder(binding.root){
        var intOptimizacionUsoMemoria = 0
        var intOptimizacionRecursoCPU = 0
        var intOptimizacionIsEsencial = 0

        fun render(application: ApplicationModel) {
            binding.tvTitle.text = application.STR_NAME

            analizarUsoMemoria( application.INT_USE_MEMORY_RAM )
            analizarRecursoCPU( application.INT_CPU_RESOURCE )
            analizarIsEsencial( application.IS_IMPORTANT )

            resultadoAnalisis( binding.ivIcon, binding.tvDescripcion )
        }

        private fun analizarUsoMemoria( usoMemoria: Int) {

            if(usoMemoria in 0..149){
                intOptimizacionUsoMemoria = 1
            }

            if(usoMemoria in 150..299){
                intOptimizacionUsoMemoria = 2
            }

            if( usoMemoria >= 300 ){
                intOptimizacionUsoMemoria = 3
            }
        }

        private fun analizarRecursoCPU( recursoCPU: Int ) {

            if(recursoCPU in 0..39){
                intOptimizacionRecursoCPU = 1
            }

            if(recursoCPU in 40..79){
                intOptimizacionRecursoCPU = 2
            }

            if( recursoCPU >= 80 ){
                intOptimizacionRecursoCPU = 3
            }
        }

        private fun analizarIsEsencial( isImportant: Boolean ) {
            if( !isImportant ){
                intOptimizacionIsEsencial = 1
            }
        }

        @SuppressLint("SetTextI18n")
        private fun resultadoAnalisis(ivIcon: ImageView, descripcion: TextView ) {
            var sumatoriaProceso = intOptimizacionUsoMemoria + intOptimizacionRecursoCPU + intOptimizacionIsEsencial

            if(sumatoriaProceso in 1..3){
                ivIcon.setBackgroundResource( R.drawable.circle_background_green )
                descripcion.text = "Esta app no consume muchos recursos, puede seguir ejecutandose."
            }

            if(sumatoriaProceso in 4..6){
                ivIcon.setBackgroundResource( R.drawable.circle_background_yellow )
                descripcion.text = "Uso intermedio de recursos, atento a posibles aumentos."
            }

            if( sumatoriaProceso >= 7 ){
                ivIcon.setBackgroundResource( R.drawable.circle_background_red )
                descripcion.text = "Elevado uso de recursos, se recomienda cerrar el app."
            }
        }
    }
}