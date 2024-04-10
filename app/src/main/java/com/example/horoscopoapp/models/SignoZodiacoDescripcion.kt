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
        ForeignKey(entity = SignoZodiaco::class,
            parentColumns = ["zod_id"],
            childColumns = ["zod_id"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["zod_id"])]
)data class SignoZodiacoDescripcion(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="des_id")
    val descripcionId: Int = 0,
    @ColumnInfo(name="des_cuerpo")
    val cuerpo: String,
    @ColumnInfo(name="des_imagen")
    val imagen: String?, //URL
    @ColumnInfo(name = "des_elemento")
    val elemento: Set<ELEMENTO>?,
    @ColumnInfo(name = "des_planetas")
    val cuerposCelestes: Set<CUERPO_CELESTE>?,
    @ColumnInfo(name = "des_piedraspreciosas")
    val piedrasPreciosas: Set<PIEDRA>?,

    @ColumnInfo(name = "zod_id")
    val signoZodiacoId: Int
){
    constructor(cuerpo: String, imagen: String?, elementos: Set<ELEMENTO>?, planetas: Set<CUERPO_CELESTE>?, piedras: Set<PIEDRA>?, signoZodiacoId: Int)
            :this(0, cuerpo, imagen, elementos, planetas, piedras, signoZodiacoId)
}

