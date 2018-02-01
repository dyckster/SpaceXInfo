package com.dyckster.spacextest.model.flight

data class Flight(
        val flightNumber: Int,
        val launchDate: Long,
        val rocket: Rocket,
        val flightLinks: FlightLinks,
        val launchSuccess: Boolean?,
        val launchSite: LaunchSite,
        val details: String?)