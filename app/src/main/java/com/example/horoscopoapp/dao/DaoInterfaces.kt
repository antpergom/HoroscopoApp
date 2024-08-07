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
        suspend fun getAllSignoZodiaco(): List<SignoZodiaco>

        @Query("SELECT * FROM tsignozodiaco WHERE zod_id = :signoZodiacoId")
        suspend fun getSignoById(signoZodiacoId: Int): SignoZodiaco?
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
        suspend fun getAllDescripcion(): List<SignoZodiacoDescripcion>

        @Query("SELECT d.*\n" +
                "FROM tdescripcion d\n" +
                "JOIN (\n" +
                "    SELECT MAX(des_id) AS min_des_id\n" +
                "    FROM tdescripcion\n" +
                "    GROUP BY zod_id\n" +
                ") min_ids ON d.des_id = min_ids.min_des_id")
        suspend fun getAllDescripcionLastUnique(): List<SignoZodiacoDescripcion>

        @Query("SELECT * FROM tdescripcion WHERE des_id = :descripcionId")
        suspend fun getDescripcionById(descripcionId: Int): SignoZodiacoDescripcion?

        @Query("SELECT * FROM tdescripcion WHERE des_id = :descripcionId ORDER BY des_id DESC LIMIT 1")
        suspend fun getDescripcionByIdLastUnique(descripcionId: Int): SignoZodiacoDescripcion?
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
        suspend fun getAllCompatibilidad(): List<SignoZodiacoCompatiblidad>

        @Query("SELECT * FROM tcompatibilidad WHERE com_id = :compatibilidadId")
        suspend fun getCompatibilidadById(compatibilidadId: Int): SignoZodiacoCompatiblidad?
    }



}