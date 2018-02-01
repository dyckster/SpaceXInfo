package com.dyckster.spacextest.data.entity.flight

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.dyckster.spacextest.model.flight.Payload

@Entity(tableName = "payload")
data class PayloadDb(
        @PrimaryKey(autoGenerate = true)
        var primaryKey: Int,
        @ColumnInfo(name = "payload_id")
        var payloadId: String,
        @ColumnInfo(name = "cap_serial")
        var capSerial: String?,
        @ColumnInfo(name = "flight_number")
        var flightNumber: Int,
        @ColumnInfo(name = "reused")
        var reused: Boolean,
        @ColumnInfo(name = "customers")
        var customers: List<String>,
        @ColumnInfo(name = "payload_type")
        var payloadType: String,
        @ColumnInfo(name = "payload_mass_kg")
        var payloadMassKg: Float?,
        @ColumnInfo(name = "payload_mass_lbs")
        var payloadMassLbs: Float?,
        @ColumnInfo(name = "orbit")
        var orbit: String?,
        @ColumnInfo(name = "mass_returned_kg")
        var massReturnedKg: Float?,
        @ColumnInfo(name = "mass_returned_lbs")
        var massReturnedLbs: Float?,
        @ColumnInfo(name = "flight_time_seconds")
        var flightTimeSeconds: Long?,
        @ColumnInfo(name = "cargo_manifest_link")
        var cargoManifestLink: String?) {
    constructor(payload: Payload, flightNumber: Int) : this(
            0,
            payload.payloadId,
            payload.capSerial,
            flightNumber,
            payload.reused,
            payload.customers,
            payload.payloadType,
            payload.payloadMassKg,
            payload.payloadMassLbs,
            payload.orbit,
            payload.massReturnedKg,
            payload.massReturnedLbs,
            payload.flightTimeSeconds,
            payload.cargoManifestLink

    )
}
