package com.dyckster.spacextest.model.rocket

import com.google.gson.annotations.SerializedName

data class FirstStageDetail(
        @SerializedName("reusable")
        val reusable: Boolean,
        @SerializedName("engines")
        val engines: Int,
        @SerializedName("fuel_amount_tons")
        val fuelAmountTons: Float,
        @SerializedName("burn_time_sec")
        val burnTimeSec: Int,
        @SerializedName("thrust_sea_level")
        val seaLevelThrust: ForceUnit,
        @SerializedName("thrust_vacuum")
        val thrustVacuum: ForceUnit
)