package com.dyckster.spacextest.data.entity.flight

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.dyckster.spacextest.model.flight.LandingType
import com.google.gson.annotations.SerializedName

@Entity(tableName = "core")
data class CoreEntity(
        @PrimaryKey(autoGenerate = true)
        var primaryKey: Int = 0,
        @SerializedName("core_serial")
        @ColumnInfo(name = "serial")
        var serial: String,
        @SerializedName("reused")
        @ColumnInfo(name = "reused")
        var reused: Boolean,
        @ColumnInfo(name = "flight_number")
        var flightNumber: Int,
        @SerializedName("land_success")
        @ColumnInfo(name = "successful_landing")
        var successfulLanding: Boolean,
        @SerializedName("landing_type")
        @ColumnInfo(name = "landing_type")
        var landingType: LandingType?,
        @SerializedName("landing_vehicle")
        @ColumnInfo(name = "landing_vehicle")
        var landingVehicle: String?)
