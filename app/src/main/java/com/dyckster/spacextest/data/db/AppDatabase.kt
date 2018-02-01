package com.dyckster.spacextest.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.dyckster.spacextest.data.entity.flight.CoreEntity
import com.dyckster.spacextest.data.entity.flight.FlightEntity
import com.dyckster.spacextest.data.entity.flight.PayloadEntity
import com.dyckster.spacextest.data.entity.flight.RocketEntity

@Database(
        entities = [FlightEntity::class, CoreEntity::class, PayloadEntity::class, RocketEntity::class],
        version = 1,
        exportSchema = false)
@TypeConverters(
        value = [Converters::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun flightsDao(): FlightsDao

    abstract fun rocketsDao(): RocketsDao
}