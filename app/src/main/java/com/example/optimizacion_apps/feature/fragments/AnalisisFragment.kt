package com.example.optimizacion_apps.feature.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.optimizacion_apps.R
import com.example.optimizacion_apps.common.MessageUtil
import com.example.optimizacion_apps.databinding.FragmentAnalisisBinding
import com.example.optimizacion_apps.domain.model.ApplicationModel
import com.example.optimizacion_apps.feature.ui.adapter.AdpItemApplication
import com.example.optimizacion_apps.feature.ui.viewmodel.AnalisisViewModel
import com.example.optimizacion_apps.feature.ui.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnalisisFragment : Fragment() {

    private val viewModel: AnalisisViewModel by viewModels()

    private var _binding: FragmentAnalisisBinding? = null
    private val binding get() = _binding!!
    private lateinit var listApplications:List<ApplicationModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalisisBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getApplications()
        initevents()
        initObservers()
    }

    private fun getApplications(){
        viewModel.getApplications()
    }

    private fun initevents() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_analisisFragment_to_homeFragment)
        }
        binding.fbAdd.setOnClickListener {
            findNavController().navigate(R.id.action_analisisFragment_to_registerFragment)
        }
    }

    private fun initObservers(){
        viewModel.list.observe(viewLifecycleOwner, Observer { list->
            listApplications = list
            if(list.isNotEmpty()){
                loadApplications()
            }else{
                MessageUtil.showToast(requireContext(), 4, "No hay data para cargar",0)
            }
        })
    }

    private fun loadApplications() {
        with(binding.rvListApps){
            layoutManager = GridLayoutManager(context, 2)
            adapter = AdpItemApplication( listApplications )
        }
    }
}