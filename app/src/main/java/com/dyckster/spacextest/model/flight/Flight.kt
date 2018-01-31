package com.dyckster.spacextest.model.flight

import com.dyckster.spacextest.model.flight.db.FlightDb
import com.dyckster.spacextest.model.flight.db.RocketDb
import com.google.gson.annotations.SerializedName

data class Flight(
        @SerializedName("flight_number")
        val flightNumber: Int,
        @SerializedName("launch_date_unix")
        val launchDate: Long,
        @SerializedName("rocket")
        val rocket: Rocket,
        @SerializedName("links")
        val flightLinks: FlightLinks,
        @SerializedName("launch_success")
        val launchSuccess: Boolean?,
        @SerializedName("launch_site")
        val launchSite: LaunchSite,
        @SerializedName("details")
        val details: String?) {

    constructor(flightDb: FlightDb, rocketDb: RocketDb, cores: List<Core>, payloads: List<Payload>) : this(
            flightDb.flightNumber,
            flightDb.launchDate,
            Rocket(
                    rocketDb.rocketId,
                    rocketDb.rocketName,
                    rocketDb.rocketType,
                    FirstStage(cores),
                    SecondStage(payloads)),
            flightDb.flightLinks,
            flightDb.launchSuccess,
            flightDb.launchSite,
            flightDb.details)


}