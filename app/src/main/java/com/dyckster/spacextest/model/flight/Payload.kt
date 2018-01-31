package com.dyckster.spacextest.model.flight

import com.dyckster.spacextest.model.flight.db.PayloadDb
import com.google.gson.annotations.SerializedName

data class Payload(
        @SerializedName("payload_id")
        val payloadId: String,
        @SerializedName("cap_serial")
        val capSerial: String?,
        @SerializedName("reused")
        val reused: Boolean,
        @SerializedName("customers")
        val customers: List<String>,
        @SerializedName("payload_type")
        val payloadType: String,
        @SerializedName("payload_mass_kg")
        val payloadMassKg: Float?,
        @SerializedName("payload_mass_lbs")
        val payloadMassLbs: Float?,
        @SerializedName("orbit")
        val orbit: String?,
        @SerializedName("mass_returned_kg")
        val massReturnedKg: Float?,
        @SerializedName("mass_returned_lbs")
        val massReturnedLbs: Float?,
        @SerializedName("flight_time_seconds")
        val flightTimeSeconds: Long?,
        @SerializedName("cargo_manifest")
        val cargoManifestLink: String?) {
    constructor(payloadDb: PayloadDb) : this(
            payloadDb.payloadId,
            payloadDb.capSerial,
            payloadDb.reused,
            payloadDb.customers,
            payloadDb.payloadType,
            payloadDb.payloadMassKg,
            payloadDb.payloadMassLbs,
            payloadDb.orbit,
            payloadDb.massReturnedKg,
            payloadDb.massReturnedLbs,
            payloadDb.flightTimeSeconds,
            payloadDb.cargoManifestLink
    )
}