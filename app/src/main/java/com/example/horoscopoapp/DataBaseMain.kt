package com.example.horoscopoapp

import androidx.room.Database
import com.example.horoscopoapp.dao.dao.PrediccionHoroscopo
import com.example.horoscopoapp.dao.dao.SignoZodiaco
import com.example.horoscopoapp.dao.dao.SignoZodiacoCompatiblidad
import com.example.horoscopoapp.dao.dao.SignoZodiacoDescripcion
import com.example.horoscopoapp.dao.dao.SignoZodiacoPrediccion

@Database(entities = [SignoZodiaco::class, SignoZodiacoCompatiblidad::class, SignoZodiacoPrediccion::class, SignoZodiacoDescripcion::class, SignoZodiacoPrediccion::class], version = 1)
abstract class DataBaseMain: RoomDataBase() {       //TODO: Entender si esto es una clase que extiende RoomDataBase o qué rol exactamente juega
}