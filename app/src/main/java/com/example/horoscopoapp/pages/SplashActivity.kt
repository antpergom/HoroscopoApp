package com.example.horoscopoapp.pages

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.horoscopoapp.R
import MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceBundel : Bundle?) {
        super.onCreate(savedInstanceBundel)
        setContentView(R.layout.activity_splash)

    }

    override fun onStart() {
        super.onStart()

        val intent = Intent(this, MainActivity:class.java)

    }

}
