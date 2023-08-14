package com.example.horoscopoapp.converters
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun <T : Enum<T>> fromList(list: List<T>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun <T : Enum<T>> toList(data: String, enumClass: Class<T>): List<T> {
        val listType = TypeToken.getParameterized(List::class.java, enumClass).type
        return gson.fromJson(data, listType)
    }
}