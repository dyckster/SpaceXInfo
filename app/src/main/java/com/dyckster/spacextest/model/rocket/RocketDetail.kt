package com.dyckster.spacextest.model.rocket

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "rocket_detail")
data class RocketDetail(
        @PrimaryKey
        @ColumnInfo(name = "id")
        @SerializedName("id")
        val id: String,
        @ColumnInfo(name = "name")
        @SerializedName("name")
        val name: String,
        @ColumnInfo(name = "type")
        @SerializedName("type")
        val type: String,
        @ColumnInfo(name = "active")
        @SerializedName("active")
        val active: Boolean,
        @ColumnInfo(name = "stages")
        @SerializedName("stages")
        val stages: Int,
        @ColumnInfo(name = "boosters")
        @SerializedName("boosters")
        val boosters: Int,
        @ColumnInfo(name = "cost_per_launch")
        @SerializedName("cost_per_launch")
        val costPerLaunch: Long,
        @ColumnInfo(name = "success_rate_pct")
        @SerializedName("success_rate_pct")
        val successRate: Int,
        @ColumnInfo(name = "first_flight")
        @SerializedName("first_flight")
        val firstFlight: String,
        @ColumnInfo(name = "country")
        @SerializedName("country")
        val country: String,
        @ColumnInfo(name = "company")
        @SerializedName("company")
        val company: String,
        @Embedded
        @SerializedName("meters")
        val height: LengthUnit,
        @Embedded
        @SerializedName("diameter")
        val diameter: LengthUnit,
        @Embedded
        @SerializedName("mass")
        val mass: MassUnit,
        //TODO() type converter
        @SerializedName("payload_weights")
        val payloadWeights: List<PayloadWeight>,
        @Embedded
        @SerializedName("first_stage")
        val firstStageDetail: FirstStageDetail,
        @Embedded
        @SerializedName("second_stage")
        val secondStageDetail: SecondStageDetail,
        @Embedded
        @SerializedName("engines")
        val engine: Engine,
        @Embedded
        @SerializedName("landing_legs")
        val landingLegs: LandingLegs,
        @ColumnInfo(name = "description")
        @SerializedName("description")
        val description: String

)