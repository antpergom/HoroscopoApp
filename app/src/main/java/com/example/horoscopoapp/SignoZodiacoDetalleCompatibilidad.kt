package com.example.horoscopoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [SignoZodiacoDetalleCompatibilidad.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignoZodiacoDetalleCompatibilidad : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_signo_zodiaco_detalle_compatibilidad,
            container,
            false
        )
    }

}