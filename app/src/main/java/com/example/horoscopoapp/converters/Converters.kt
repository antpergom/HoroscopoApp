package com.example.horoscopoapp.converters
import androidx.room.TypeConverter
import com.example.horoscopoapp.dao.CUERPO_CELESTE
import com.example.horoscopoapp.dao.ELEMENTO
import com.example.horoscopoapp.dao.PIEDRA
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.LocalDateTime

object Converters {
    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    fun fromTimestamp(timestampDate: String?): LocalDateTime?{
        return timestampDate?.let{LocalDateTime.parse(it)}
    }

    @TypeConverter
    @JvmStatic
    fun fromDateTime(date: LocalDateTime?): String? {
        return date?.toString()
    }

    @TypeConverter
    @JvmStatic
    fun fromIntListToCommaString(intSet: Set<Int>?): String? {
        return intSet?.joinToString(",")
    }

    @TypeConverter
    @JvmStatic
    fun fromCommaStringToIntList(intString: String?): Set<Int>? {
        return intString?.split(",")?.map{it.toInt()}?.toSet()
    }

    //ELEMENTO
    @TypeConverter
    @JvmStatic
    fun fromEnumListToStringELEMENTO(enumSet: Set<ELEMENTO>?): String? {
        return enumSet?.joinToString(separator = ","){ it.name}
    }

    @TypeConverter
    @JvmStatic
    fun fromEnumStringToListELEMENTO(enumString: String?): Set<ELEMENTO>? {
        return enumString?.split(",")?.map{ELEMENTO.valueOf(it)}?.toSet()
    }

    //CUERPO_CELESTE
    @TypeConverter
    @JvmStatic
    fun fromEnumSetToStringCUEPO_CELESTE(enumSet: Set<CUERPO_CELESTE>?): String? {
        return enumSet?.joinToString(separator = ","){ it.name}
    }

    @TypeConverter
    @JvmStatic
    fun fromEnumStringToSetCUEPO_CELESTE(enumString: String?): Set<CUERPO_CELESTE>? {
        return enumString?.split(",")?.map { CUERPO_CELESTE.valueOf(it) }?.toSet()
    }

    //PIEDRA
    @TypeConverter
    @JvmStatic
    fun fromEnumSetToStringPIEDRA(enumSet: Set<PIEDRA>?): String? {
        return enumSet?.joinToString(separator = ","){ it.name}
    }

    @TypeConverter
    @JvmStatic
    fun fromEnumStringToSetPIEDRA(enumString: String?): Set<PIEDRA>? {
        return enumString?.split(",")?.map { PIEDRA.valueOf(it) }?.toSet()
    }

}