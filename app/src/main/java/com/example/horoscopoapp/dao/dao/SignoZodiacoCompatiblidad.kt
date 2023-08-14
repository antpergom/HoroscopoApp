package com.example.horoscopoapp.dao.dao

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class SignoZodiacoCompatiblidad(
    @PrimaryKey
    @ColumnInfo(name = "com_id")
    val signoZodiacoCompatibilidadId: Int,
    @ColumnInfo(name = "com_amor")
    val compatibilidadAmor: Int,
    @ColumnInfo(name = "com_sexo")
    val compatibilidadSexo: Int,
    @ColumnInfo(name = "com_negocio")
    val compatibilidadNegocio: Int
)
