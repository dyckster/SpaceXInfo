package com.dyckster.spacextest.data.entity.flight

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.dyckster.spacextest.model.flight.Core
import com.dyckster.spacextest.model.flight.LandingType

@Entity(tableName = "core")
data class CoreDb(
        @PrimaryKey(autoGenerate = true)
        var primaryKey: Int,
        @ColumnInfo(name = "serial")
        var serial: String,
        @ColumnInfo(name = "reused")
        var reused: Boolean,
        @ColumnInfo(name = "flight_number")
        var flightNumber: Int,
        @ColumnInfo(name = "successful_landing")
        var successfulLanding: Boolean,
        @ColumnInfo(name = "landing_type")
        var landingType: LandingType?,
        @ColumnInfo(name = "landing_vehicle")
        var landingVehicle: String?) {
    constructor(core: Core, flightNumber: Int) : this(
            0,
            core.serial,
            core.reused,
            flightNumber,
            core.successfulLanding,
            core.landingType,
            core.landingVehicle
    )
}