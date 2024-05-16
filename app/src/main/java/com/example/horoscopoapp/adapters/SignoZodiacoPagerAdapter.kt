package com.example.horoscopoapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class SignoZodiacoPagerAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList: MutableList<Fragment> = mutableListOf()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(fragmentPosit: Int): Fragment {
        /*
        return when(fragmentPosit) {
            //0 -> DescripcionFragment()
            //1 -> PrediccionFragment()
            //2 -> DescripcionFragment()
            else -> throw IllegalArgumentException("Posición del tab inválida")
        }
         */
        return fragmentList[fragmentPosit]
    }

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }

}