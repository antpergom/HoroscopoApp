package com.example.horoscopoapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.horoscopoapp.models.SignoZodiaco
import com.example.horoscopoapp.models.SignoZodiacoCompatiblidad
import com.example.horoscopoapp.models.SignoZodiacoDescripcion
import com.example.horoscopoapp.models.SignoZodiacoPrediccion

class DaoInterfaces {

    @Dao
    interface SignoZodiacoDao {
        @Insert
        suspend fun insert(vararg signoZodiaco: SignoZodiaco)

        @Update
        suspend fun update(vararg signoZodiaco: SignoZodiaco)

        @Delete
        suspend fun delete(vararg signoZodiaco: SignoZodiaco)

        @Query("SELECT * FROM tsignozodiaco")
        suspend fun getAllPredicciones(): List<SignoZodiaco>

        @Query("SELECT * FROM tsignozodiaco WHERE zod_id = :signoZodiacoId")
        suspend fun getPrediccionById(signoZodiacoId: Int): SignoZodiaco?
    }

    @Dao
    interface SignoZodiacoPrediccionDao {
        @Insert
        suspend fun insert(vararg prediccion: SignoZodiacoPrediccion)

        @Update
        suspend fun update(vararg prediccion: SignoZodiacoPrediccion)

        @Delete
        suspend fun delete(vararg prediccion: SignoZodiacoPrediccion)

        @Query("SELECT * FROM tprediccion")
        suspend fun getAllPredicciones(): List<SignoZodiacoPrediccion>

        @Query("SELECT * FROM tprediccion WHERE pre_id = :prediccionId")
        suspend fun getPrediccionById(prediccionId: Int): SignoZodiacoPrediccion?
    }

    @Dao
    interface SignoZodiacoDescripcionDao {
        @Insert
        suspend fun insert(vararg descripcion: SignoZodiacoDescripcion)
        @Update
        suspend fun update(vararg descripcion: SignoZodiacoPrediccion)

        @Delete
        suspend fun delete(vararg descripcion: SignoZodiacoPrediccion)

        @Query("SELECT * FROM tdescripcion")
        suspend fun getAllPredicciones(): List<SignoZodiacoDescripcion>

        @Query("SELECT * FROM tdescripcion WHERE des_id = :descripcionId")
        suspend fun getPrediccionById(descripcionId: Int): SignoZodiacoDescripcion?
    }

    @Dao
    interface SignoZodiacoCompatibilidadDao {
        @Insert
        suspend fun insert(vararg compatibilidad: SignoZodiacoCompatiblidad)

        @Update
        suspend fun update(vararg compatibilidad: SignoZodiacoCompatiblidad)

        @Delete
        suspend fun delete(vararg compatibilidad: SignoZodiacoCompatiblidad)

        @Query("SELECT * FROM tcompatibilidad")
        suspend fun getAllPredicciones(): List<SignoZodiacoCompatiblidad>

        @Query("SELECT * FROM tcompatibilidad WHERE com_id = :compatibilidadId")
        suspend fun getPrediccionById(compatibilidadId: Int): SignoZodiacoCompatiblidad?
    }



}