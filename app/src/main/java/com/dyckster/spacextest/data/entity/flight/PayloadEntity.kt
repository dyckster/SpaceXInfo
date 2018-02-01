package com.dyckster.spacextest.data.entity.flight

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "payload")
data class PayloadEntity(
        @PrimaryKey(autoGenerate = true)
        var primaryKey: Int,
        @SerializedName("payload_id")
        @ColumnInfo(name = "payload_id")
        var payloadId: String,
        @ColumnInfo(name = "cap_serial")
        @SerializedName("cap_serial")
        var capSerial: String?,
        @ColumnInfo(name = "flight_number")
        var flightNumber: Int,
        @ColumnInfo(name = "reused")
        @SerializedName("reused")
        var reused: Boolean,
        @SerializedName("customers")
        @ColumnInfo(name = "customers")
        var customers: List<String>,
        @SerializedName("payload_type")
        @ColumnInfo(name = "payload_type")
        var payloadType: String,
        @SerializedName("payload_mass_kg")
        @ColumnInfo(name = "payload_mass_kg")
        var payloadMassKg: Float?,
        @ColumnInfo(name = "payload_mass_lbs")
        @SerializedName("payload_mass_lbs")
        var payloadMassLbs: Float?,
        @ColumnInfo(name = "orbit")
        @SerializedName("orbit")
        var orbit: String?,
        @SerializedName("mass_returned_kg")
        @ColumnInfo(name = "mass_returned_kg")
        var massReturnedKg: Float?,
        @SerializedName("mass_returned_lbs")
        @ColumnInfo(name = "mass_returned_lbs")
        var massReturnedLbs: Float?,
        @SerializedName("flight_time_seconds")
        @ColumnInfo(name = "flight_time_seconds")
        var flightTimeSeconds: Long?,
        @SerializedName("cargo_manifest")
        @ColumnInfo(name = "cargo_manifest_link")
        var cargoManifestLink: String?)
