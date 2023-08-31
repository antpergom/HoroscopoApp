package com.example.horoscopoapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "tprediccion",
    foreignKeys = [
        ForeignKey(entity = SignoZodiaco::class, parentColumns = ["zod_id"], childColumns = ["zod_id"])
    ],
    indices = [Index(value = ["zod_id"])]
)data class SignoZodiacoPrediccion(
    @PrimaryKey
    @ColumnInfo(name = "pre_id")
    val prediccionId: Int,
    @ColumnInfo(name = "pre_fecha")
    val fecha: LocalDateTime?,
    @ColumnInfo(name = "pre_descripcion")
    val descripcion: String?,
    @ColumnInfo(name = "pre_amor")
    val prediccionAmor: String?,
    @ColumnInfo(name = "pre_amigosfamilia")
    val prediccionAmistadFamilia: String?,
    @ColumnInfo(name = "pre_salud")
    val predicionSalud: String?,
    @ColumnInfo(name = "pre_dinero")
    val preediccionDinero: String?,
    @ColumnInfo(name = "pre_numerosuerte")
    val numerosSuerte: List<Int>?,
    @ColumnInfo(name = "pre_palabrasuerte")
    val palabraSuerte: String?,
    @ColumnInfo(name = "pre_colorsuerte")
    val colorSuerte: String?,
    @ColumnInfo(name = "pre_id")
    val estadoPlaneta: Int?,

    @ColumnInfo(name = "zod_id")
    val signoZodiacoId: Int
)
