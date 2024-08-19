package com.example.optimizacion_apps.feature.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.optimizacion_apps.R
import com.example.optimizacion_apps.common.MessageUtil
import com.example.optimizacion_apps.database.entity.ApplicationEntity
import com.example.optimizacion_apps.databinding.FragmentRegisterBinding
import com.example.optimizacion_apps.feature.ui.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by viewModels()

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initevents()
        initObservers()
    }

    private fun initObservers() {
        viewModel.isRegister.observe(viewLifecycleOwner, Observer {
            it.let {
                if(it){
                    MessageUtil.showToast(requireContext(), 1, "Registro exitoso",0)
                    findNavController().navigate(R.id.action_registerFragment_to_analisisFragment)
                }else{
                    MessageUtil.showToast(requireContext(), 4, "No se registro",0)
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun initevents() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_analisisFragment)
        }

        binding.btnRegister.setOnClickListener {
            validateDataForm()
        }
    }

    private fun validateDataForm() {
        if( binding.etNombreApp.text.toString().isEmpty()){
            MessageUtil.showToast(requireContext(), 4, "Debe escribir un nombre de app",0)
            return
        }

        if( binding.etRecursoCpu.text.toString().isEmpty()){
            MessageUtil.showToast(requireContext(), 4, "Debe escribir el recurso de CPU",0)
            return
        }

        if( binding.etUsoMemoria.text.toString().isEmpty()){
            MessageUtil.showToast(requireContext(), 4, "Debe escribir el uso de memoria",0)
            return
        }

        registerData()
    }

    private fun registerData() {
        val itemRegister = ApplicationEntity(
            0,
            binding.etNombreApp.text.toString(),
            binding.etRecursoCpu.text.toString().toInt(),
            binding.etUsoMemoria.text.toString().toInt(),
            if (binding.cbIsImportant.isChecked) true else false
        )
        viewModel.RegisterForm( itemRegister )
    }
}