package com.example.horoscopoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.horoscopoapp.activity.adapters.SignoZodiacoAdapterPager
import com.example.horoscopoapp.databinding.FragmentSignoZodiacoDetalleBinding

private const val NUM_PAGES = 3

class SignoZodiacoDetalleFragment : Fragment() {

    private var _binding: FragmentSignoZodiacoDetalleBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignoZodiacoDetalleBinding.inflate(inflater, null, false)
        //viewPager = binding.viewPagerInclude.viewPagerSignoZodiaco
        //viewPager?.adapter = SignoZodiacoAdapter(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = binding.viewPagerInclude.viewPagerSignoZodiaco
        val adapter = SignoZodiacoAdapterPager(childFragmentManager)
        //viewPager.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignoZodiacoDetalleFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}