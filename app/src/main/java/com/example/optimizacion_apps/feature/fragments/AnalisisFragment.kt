package com.example.optimizacion_apps.feature.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.optimizacion_apps.R
import com.example.optimizacion_apps.databinding.FragmentAnalisisBinding
import com.example.optimizacion_apps.databinding.FragmentHomeBinding

class AnalisisFragment : Fragment() {

    private var _binding: FragmentAnalisisBinding? = null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnalisisBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}