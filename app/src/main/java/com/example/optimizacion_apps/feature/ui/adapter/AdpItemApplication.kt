package com.example.optimizacion_apps.feature.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
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
        fun render( application: ApplicationModel) {
            binding.tvTitle.text = application.STR_NAME
        }
    }
}