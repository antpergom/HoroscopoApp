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
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pre_id")
    val prediccionId: Int = 0,
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
    val prediccionDinero: String?,
    @ColumnInfo(name = "pre_numerosuerte")
    val numerosSuerte: Set<Int>?,
    @ColumnInfo(name = "pre_palabrasuerte")
    val palabraSuerte: String?,
    @ColumnInfo(name = "pre_colorsuerte")
    val colorSuerte: String?,
    @ColumnInfo(name = "pre_estadoplaneta")
    val estadoPlaneta: Int?,

    @ColumnInfo(name = "zod_id")
    val signoZodiacoId: Int
){
    constructor(fecha: LocalDateTime?, descripcion: String?, amor: String?, amistadFamilia: String?, salud: String?, dinero: String?,
                numerosSuerte: Set<Int>, palabraSuerte: String?, colorSuerte: String?, estadoPlaneta: Int?, signoZodiacoInt: Int):
            this(0, fecha, descripcion, amor, amistadFamilia, salud, dinero, numerosSuerte, palabraSuerte,
                colorSuerte, estadoPlaneta, signoZodiacoInt)
}
