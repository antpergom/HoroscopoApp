package com.example.horoscopoapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.horoscopoapp.converters.Converters
import com.example.horoscopoapp.models.SignoZodiaco
import com.example.horoscopoapp.models.SignoZodiacoCompatiblidad
import com.example.horoscopoapp.models.SignoZodiacoDescripcion
import com.example.horoscopoapp.models.SignoZodiacoPrediccion

@Database(entities = [SignoZodiaco::class, SignoZodiacoCompatiblidad::class, SignoZodiacoPrediccion::class, SignoZodiacoDescripcion::class], version = 1)
@TypeConverters(Converters::class)
abstract class DataBaseMain: RoomDatabase() {

    abstract fun SignoZodiacoDao(): DaoInterfaces.SignoZodiacoDao;
    abstract fun SignoZodiacoPrediccionDao(): DaoInterfaces.SignoZodiacoPrediccionDao;
    abstract fun SignoZodiacoDescripcionDao(): DaoInterfaces.SignoZodiacoDescripcionDao;
    abstract fun SignoZodiacoCompatibilidadDao(): DaoInterfaces.SignoZodiacoCompatibilidadDao;

    companion object {
        @Volatile
        private var db: DataBaseMain? = null
        val DATATBASE_NAME : String = "horoscopo-db";

        fun getDatabase(context: Context): DataBaseMain {
            val tempInstance = db
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                try{
                    val instance = Room.databaseBuilder(
                        context,
                        DataBaseMain::class.java,
                        DATATBASE_NAME
                    ).build()
                    db = instance
                    return instance
                }catch(e: Exception){
                    e.stackTrace
                }
            return db!!
            }
        }
    }


}