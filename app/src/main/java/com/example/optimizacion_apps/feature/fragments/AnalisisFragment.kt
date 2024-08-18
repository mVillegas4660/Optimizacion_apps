package com.example.optimizacion_apps.feature.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.optimizacion_apps.R
import com.example.optimizacion_apps.databinding.FragmentAnalisisBinding
import com.example.optimizacion_apps.feature.ui.viewmodel.AnalisisViewModel
import com.example.optimizacion_apps.feature.ui.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnalisisFragment : Fragment() {

    private val viewModel: AnalisisViewModel by viewModels()

    private var _binding: FragmentAnalisisBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalisisBinding.inflate(layoutInflater, container, false)

        initevents()
        return binding.root
    }

    private fun initevents() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_analisisFragment_to_homeFragment)
        }
        binding.fbAdd.setOnClickListener {
            findNavController().navigate(R.id.action_analisisFragment_to_registerFragment)
        }
    }
}