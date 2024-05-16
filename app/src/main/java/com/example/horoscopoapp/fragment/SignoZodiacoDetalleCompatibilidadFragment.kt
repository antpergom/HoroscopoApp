package com.example.horoscopoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.horoscopoapp.databinding.FragmentSignoZodiacoDetalleCompatibilidadBinding

class SignoZodiacoDetalleCompatibilidadFragment : Fragment() {

    //TODO: ATENCIÓN! Esta va a ser la clase que contenga el TabLayout con sus transiciones y toda la pesca
    private var _binding: FragmentSignoZodiacoDetalleCompatibilidadBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignoZodiacoDetalleCompatibilidadBinding.inflate(inflater, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}