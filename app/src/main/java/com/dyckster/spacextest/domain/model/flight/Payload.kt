package com.dyckster.spacextest.domain.model.flight

data class Payload(
        val payloadId: String,
        val capSerial: String?,
        val reused: Boolean,
        val customers: List<String>,
        val payloadType: String,
        val payloadMassKg: Float?,
        val payloadMassLbs: Float?,
        val orbit: String?,
        val massReturnedKg: Float?,
        val massReturnedLbs: Float?,
        val flightTimeSeconds: Long?,
        val cargoManifestLink: String?)