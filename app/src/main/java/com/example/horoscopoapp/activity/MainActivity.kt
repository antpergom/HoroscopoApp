package com.example.horoscopoapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_activity_fragment_container)
        if (navHostFragment != null) {
            navController = navHostFragment.findNavController()
        }
    }

    private fun loadFragment(f: Fragment) {
        when(f) {
            /*
            is SignoZodiacoMenuFragment -> {
                val binding = FragmentSignoZodiacoMenuBinding.inflate(layoutInflater)
            }
            is DescripcionFragment -> {
                val binding = FragmentZodiacoDescripcionBinding.inflate(layoutInflater)
            }
            is PrediccionFragment -> {
                val binding = FragmentPrediccionBinding.inflate(layoutInflater)
            }

             */
        }
    }



}