package com.dyckster.spacextest.model.flight

import com.dyckster.spacextest.model.flight.db.CoreDb
import com.google.gson.annotations.SerializedName

data class Core(
        @SerializedName("core_serial")
        val serial: String,
        @SerializedName("reused")
        val reused: Boolean,
        @SerializedName("land_success")
        val successfulLanding: Boolean,
        @SerializedName("landing_type")
        val landingType: LandingType?,
        @SerializedName("landing_vehicle")
        val landingVehicle: String?
) {
    constructor(coreDb: CoreDb) : this(
            coreDb.serial,
            coreDb.reused,
            coreDb.successfulLanding,
            coreDb.landingType,
            coreDb.landingVehicle
    )
}