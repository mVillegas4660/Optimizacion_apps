package com.example.optimizacion_apps.feature.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.optimizacion_apps.R
import com.example.optimizacion_apps.databinding.FragmentAnalisisBinding

class AnalisisFragment : Fragment() {

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