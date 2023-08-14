package com.example.horoscopoapp.dao.dao

import androidx.room.Dao
import androidx.room.Insert

class DaoInterfaces {

    @Dao
    interface SignoZodiacoPrediccionDao {
        @Insert
        suspend fun insert(prediccion: SignoZodiacoPrediccion)
    }

    @Dao
    interface SignoZodiacoDao {
        @Insert
        suspend fun insert(signoZodiaco: SignoZodiaco)
    }


    @Dao
    interface SignoZodiacoCompatibilidadDao {
        @Insert
        suspend fun insert(compatibilidad: SignoZodiacoCompatiblidad)
    }

    @Dao
    interface SignoZodiacoDescripcionDao {
        @Insert
        suspend fun insert(descripcion: SignoZodiacoDescripcion)
    }

}