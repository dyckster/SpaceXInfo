package com.dyckster.spacextest.data.db

import android.arch.persistence.room.TypeConverter
import com.dyckster.spacextest.domain.model.flight.LandingType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromStringList(list: List<String>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun landingTypeFromString(value: String): LandingType {
        return LandingType.fromString(value)
    }

    @TypeConverter
    fun fromLandingType(landingType: LandingType?): String {
        return landingType?.name ?: ""
    }


}