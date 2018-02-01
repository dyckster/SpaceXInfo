package com.dyckster.spacextest.data.entity.flight

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.dyckster.spacextest.model.flight.Flight

@Entity(tableName = "rocket_flight")
data class RocketDb(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        @ColumnInfo(name = "rocket_id")
        var rocketId: String,
        @ColumnInfo(name = "flight_number")
        var flightNumber: Int,
        @ColumnInfo(name = "rocket_name")
        var rocketName: String,
        @ColumnInfo(name = "rocket_type")
        var rocketType: String) {
    constructor(flight: Flight) : this(
            0,
            flight.rocket.rocketId,
            flight.flightNumber,
            flight.rocket.rocketName,
            flight.rocket.rocketType)
}