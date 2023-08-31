package com.example.horoscopoapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="tcompatibilidad")
data class SignoZodiacoCompatiblidad(
    @PrimaryKey
    @ColumnInfo(name = "com_id")
    val compatibilidadId: Int,
    @ColumnInfo(name = "com_amor")
    val compatibilidadAmor: Int?,
    @ColumnInfo(name = "com_sexo")
    val compatibilidadSexo: Int?,
    @ColumnInfo(name = "com_negocio")
    val compatibilidadNegocio: Int?
)
