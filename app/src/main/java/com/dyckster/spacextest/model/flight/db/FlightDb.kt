package com.dyckster.spacextest.model.flight.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.dyckster.spacextest.model.flight.Flight
import com.dyckster.spacextest.model.flight.FlightLinks
import com.dyckster.spacextest.model.flight.LaunchSite

@Entity(tableName = "flight")
data class FlightDb(
        @PrimaryKey
        @ColumnInfo(name = "flight_number")
        var flightNumber: Int,
        @ColumnInfo(name = "launch_date")
        var launchDate: Long,
        @Embedded
        var flightLinks: FlightLinks,
        @ColumnInfo(name = "launch_success")
        var launchSuccess: Boolean?,
        @Embedded
        var launchSite: LaunchSite,
        @ColumnInfo(name = "details")
        var details: String?) {
    constructor(flight: Flight) : this(
            flight.flightNumber,
            flight.launchDate,
            flight.flightLinks,
            flight.launchSuccess,
            flight.launchSite,
            flight.details)
}