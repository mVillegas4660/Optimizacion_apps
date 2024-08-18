package com.example.optimizacion_apps.feature.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.optimizacion_apps.R
import com.example.optimizacion_apps.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        initEvents()

        return binding.root
    }

    private fun initEvents(){
        binding.btnInicio.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_analisisFragment)
        }
    }
}