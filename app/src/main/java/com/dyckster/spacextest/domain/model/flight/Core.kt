package com.dyckster.spacextest.domain.model.flight

data class Core(
        val serial: String,
        val reused: Boolean,
        val successfulLanding: Boolean,
        val landingType: LandingType?,
        val landingVehicle: String?
)