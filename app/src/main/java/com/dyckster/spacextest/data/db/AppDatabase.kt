package com.dyckster.spacextest.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.dyckster.spacextest.model.flight.db.CoreDb
import com.dyckster.spacextest.model.flight.db.FlightDb
import com.dyckster.spacextest.model.flight.db.PayloadDb
import com.dyckster.spacextest.model.flight.db.RocketDb

@Database(
        entities = [FlightDb::class, CoreDb::class, PayloadDb::class, RocketDb::class],
        version = 1,
        exportSchema = false)
@TypeConverters(
        value = [Converters::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun flightsDao(): FlightsDao
}