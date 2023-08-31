package com.example.horoscopoapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.horoscopoapp.dao.CUERPO_CELESTE
import com.example.horoscopoapp.dao.ELEMENTO
import com.example.horoscopoapp.dao.PIEDRA

@Entity(tableName="tdescripcion",
    foreignKeys = [
        ForeignKey(entity = SignoZodiaco::class, parentColumns = ["zod_id"], childColumns = ["zod_id"])
    ],
    indices = [Index(value = ["zod_id"])]
)data class SignoZodiacoDescripcion(
    @PrimaryKey
    @ColumnInfo(name="des_id")
    val descripcionId: Int,
    /*
    @ColumnInfo(name="zod_nombre")
    val nombre: String,
     */
    @ColumnInfo(name="des_imagen")
    val imagen: String?, //URL
    @ColumnInfo(name = "des_elemento")
    val elemento: List<ELEMENTO>?,
    @ColumnInfo(name = "des_planetas")
    val cuerposCelestes: List<CUERPO_CELESTE>?,
    @ColumnInfo(name = "des_piedraspreciosas")
    val piedrasPreciosas: List<PIEDRA>?,

    @ColumnInfo(name = "zod_id")
    val signoZodiacoId: Int
)

