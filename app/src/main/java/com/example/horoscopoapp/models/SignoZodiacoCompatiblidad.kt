package com.example.horoscopoapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO: dejar para más adelante
@Entity(tableName="tcompatibilidad")
data class SignoZodiacoCompatiblidad(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "com_id")
    val compatibilidadId: Int = 0,
    @ColumnInfo(name = "com_amor")
    val compatibilidadAmor: Int?,
    @ColumnInfo(name = "com_sexo")
    val compatibilidadSexo: Int?,
    @ColumnInfo(name = "com_negocio")
    val compatibilidadNegocio: Int?
)
