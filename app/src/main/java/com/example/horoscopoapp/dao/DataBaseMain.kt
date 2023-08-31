package com.example.horoscopoapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.horoscopoapp.models.SignoZodiaco
import com.example.horoscopoapp.models.SignoZodiacoCompatiblidad
import com.example.horoscopoapp.models.SignoZodiacoDescripcion
import com.example.horoscopoapp.models.SignoZodiacoPrediccion

@Database(entities = [SignoZodiaco::class, SignoZodiacoCompatiblidad::class, SignoZodiacoPrediccion::class, SignoZodiacoDescripcion::class, SignoZodiacoPrediccion::class], version = 1)
abstract class DataBaseMain: RoomDatabase() {       //TODO: Entender si esto es una clase que extiende RoomDataBase o qué rol exactamente juega

    val DATATBASE_NAME : String = "horoscopo-db";

    abstract fun SignoZodiacoDao(): DaoInterfaces.SignoZodiacoDao;
    abstract fun SignoZodiacoPrediccionDao(): DaoInterfaces.SignoZodiacoPrediccionDao;
    abstract fun SignoZodiacoDescripcionDao(): DaoInterfaces.SignoZodiacoDescripcionDao;
    abstract fun SignoZodiacoCompatibilidadDao(): DaoInterfaces.SignoZodiacoCompatibilidadDao;

    //Llamada: val database = DatabaseMain.getDatabase(context)
    companion object {
        @Volatile
        private var db: DataBaseMain? = null

        fun getDatabase(context: Context): DataBaseMain {
            val tempInstance = db
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBaseMain::class.java,
                    "horoscopo-db"
                ).build()
                db = instance
                return instance
            }
        }
    }


}