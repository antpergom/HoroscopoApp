package com.example.horoscopoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.horoscopoapp.adapters.SignoZodiacoPagerAdapter
import com.example.horoscopoapp.databinding.FragmentSignoZodiacoDetalleBinding

private const val NUM_PAGES = 3

class SignoZodiacoDetalleFragment : Fragment() {

    //TODO: ATENCIÓN! Esta va a ser la clase que contenga el TabLayout con sus transiciones y toda la pesca
    private var _binding: FragmentSignoZodiacoDetalleBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignoZodiacoDetalleBinding.inflate(inflater, null, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SignoZodiacoPagerAdapter(childFragmentManager)
        adapter.addFragment(SignoZodiacoDetalleDescripcionFragment())
        adapter.addFragment(SignoZodiacoDetallePrediccionFragment())
        adapter.addFragment(SignoZodiacoDetalleCompatibilidadFragment())
        viewPager = binding.viewPagerInclude.viewPagerSignoZodiacoDetalle
        viewPager.adapter = adapter
    }

}