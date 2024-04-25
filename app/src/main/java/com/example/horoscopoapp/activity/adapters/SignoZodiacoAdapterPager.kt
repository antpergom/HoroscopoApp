package com.example.horoscopoapp.activity.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.horoscopoapp.fragment.DescripcionFragment
import com.example.horoscopoapp.fragment.PrediccionFragment
import java.lang.IllegalArgumentException

class SignoZodiacoAdapterPager(fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val NUM_PAGINAS: Int = 3

    override fun getCount(): Int {
        return NUM_PAGINAS
    }

    override fun getItem(fragmentPosit: Int): Fragment {
        return when(fragmentPosit) {
            0 -> DescripcionFragment()
            1 -> PrediccionFragment()
            2 -> DescripcionFragment()
            else -> throw IllegalArgumentException("Posición del tab inválida")
        }
    }

}