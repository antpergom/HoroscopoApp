package com.example.horoscopoapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="tsignozodiaco")
data class SignoZodiaco(
    @PrimaryKey
    @ColumnInfo(name="zod_id")
    val signoZodiacoId: Int,
    @ColumnInfo(name="zod_nombre")
    val nombre: String?
    /*,
    @ColumnInfo(name="zod_imagen")
    val imagen: String //URL
    */
)

