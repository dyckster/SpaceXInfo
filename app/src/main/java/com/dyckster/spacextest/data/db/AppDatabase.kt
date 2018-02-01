package com.dyckster.spacextest.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.dyckster.spacextest.data.entity.flight.CoreDb
import com.dyckster.spacextest.data.entity.flight.FlightDb
import com.dyckster.spacextest.data.entity.flight.PayloadDb
import com.dyckster.spacextest.data.entity.flight.RocketDb

@Database(
        entities = [FlightDb::class, CoreDb::class, PayloadDb::class, RocketDb::class],
        version = 1,
        exportSchema = false)
@TypeConverters(
        value = [Converters::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun flightsDao(): FlightsDao

    abstract fun rocketsDao(): RocketsDao
}