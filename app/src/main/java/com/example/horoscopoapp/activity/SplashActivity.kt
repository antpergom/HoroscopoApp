package com.example.horoscopoapp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.lifecycle.lifecycleScope
import com.example.horoscopoapp.dao.CUERPO_CELESTE
import com.example.horoscopoapp.dao.DataBaseMain
import com.example.horoscopoapp.dao.ELEMENTO
import com.example.horoscopoapp.dao.PIEDRA
import com.example.horoscopoapp.databinding.ActivitySplashBinding
import com.example.horoscopoapp.models.SignoZodiaco
import com.example.horoscopoapp.models.SignoZodiacoDescripcion
import com.example.horoscopoapp.models.SignoZodiacoPrediccion
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceBundel : Bundle?) {
        super.onCreate(savedInstanceBundel)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val testButton = binding.button2
        testButton.setOnClickListener {
            testDAO()
        }

        val pantallaPrincipalButton = binding.button3
        pantallaPrincipalButton.setOnClickListener {
            val toMainIntent= Intent(applicationContext, MainActivity::class.java)
            startActivity(toMainIntent)
        }
    }

    private fun testDAO(){
        try{
            createDatabase()
            populateDatabase()
            Toast.makeText(this, "Pruebas finalizadas", Toast.LENGTH_SHORT).show()
        }catch(e: Exception){
            Toast.makeText(this, "Pruebas fallidas", Toast.LENGTH_SHORT).show()
        }

    }

    private fun createDatabase(){
        try{
            val db = DataBaseMain.getDatabase(applicationContext)
        }catch(e: Exception){
            Toast.makeText(this, "Fallo en la creación de BD", Toast.LENGTH_LONG).show()
        }
    }

    private fun populateDatabase(){
        populateSignoZodiaco()

        populateDescripcion()
        //populatePrediccion()
        //populateCompatibilidad()
    }

    private fun populateSignoZodiaco(){
        try{
            val db = DataBaseMain.getDatabase(applicationContext)
            val s1 = SignoZodiaco("Aries")
            val s2 = SignoZodiaco("Leo")
            val s3 = SignoZodiaco("Libra")
            val s4 = SignoZodiaco("Acuario")
            lifecycleScope.launch() {
                db.SignoZodiacoDao().insert(s1, s2, s3, s4)
            }
            //Log.d("Signos insertados", listOf<SignoZodiaco>(s1, s2, s3, s4).toString())
            lifecycleScope.launch() {
                val signosExt = db.SignoZodiacoDao().getAllSignoZodiaco()
                Log.d("Signos extraidos", signosExt.toString())
            }

        }catch(e: Exception){
            Toast.makeText(this, "Fallo en la población de BD", Toast.LENGTH_LONG).show()
        }
    }

    private fun populateDescripcion(){
        val db = DataBaseMain.getDatabase(applicationContext)
        var signos: List<SignoZodiaco> = listOf()
        var listaDescInsert: MutableList<SignoZodiacoDescripcion> = mutableListOf()

        lifecycleScope.launch(){
            signos = async { db.SignoZodiacoDao().getAllSignoZodiaco() }.await()
            Log.d("Signos extraidos 2", signos.toString())

            val piedras = mutableSetOf<PIEDRA>(PIEDRA.AGATA, PIEDRA.AMATISTA, PIEDRA.JADE, PIEDRA.LAPISLAZULI)
            val planetas = mutableSetOf<CUERPO_CELESTE>(CUERPO_CELESTE.MARTE, CUERPO_CELESTE.SOL, CUERPO_CELESTE.NEPTUNO)
            val elementos = mutableSetOf<ELEMENTO>(ELEMENTO.AGUA, ELEMENTO.FUEGO, ELEMENTO.TIERRA)
            for(s in signos){
                for (i in 1..3){
                    val desc1 = SignoZodiacoDescripcion("descripcion{$i}", "imagen test",
                        elementos.shuffled().toSet(), planetas.shuffled().toSet(), piedras.shuffled().toSet(), i)
                    listaDescInsert.add(desc1)
                }
            }

            async {db.SignoZodiacoDescripcionDao().insert(*listaDescInsert.toTypedArray())}.await()
            val descExt = async {db.SignoZodiacoDescripcionDao().getAllDescripcion() }.await()
            Log.d("Descripciones extraidas", descExt.toString())
        }
    }

    private fun populatePrediccion(){
        val db = DataBaseMain.getDatabase(this)
        var signos: List<SignoZodiaco> = listOf()
        lifecycleScope.launch(){
            signos = db.SignoZodiacoDao().getAllSignoZodiaco()
        }
        val textAux: String = LoremIpsum(50).toString() //.split(" ").shuffled().joinToString(" ")
        val textAux2: String = LoremIpsum(8).toString().split(" ").shuffled().joinToString(" ")

        for(s in signos){
            /*
                constructor(fecha: LocalDateTime?, descripcion: String?, amor: String?, amistadFamilia: String?, salud: String?, dinero: String?,
                numerosSuerte: Set<Int>, palabraSuerte: String?, colorSuerte: String?, estadoPlaneta: Int?, signoZodiacoInt: Int):
             */
            val pred = SignoZodiacoPrediccion(LocalDateTime.now(), textAux.split(" ").shuffled().joinToString(" "), textAux2, textAux2, textAux2,
                textAux2, setOf(2, 3), "vaca loca", "aguamarina", 0, s.signoZodiacoId)
            lifecycleScope.launch {
                db.SignoZodiacoPrediccionDao().insert(pred)
            }
        }

        lifecycleScope.launch() {
            val predExt = db.SignoZodiacoPrediccionDao().getAllPredicciones()
            Log.d("Predicciones extraidas", predExt.toString())
        }

    }

    private fun populateCompatibilidad(){

    }

}
