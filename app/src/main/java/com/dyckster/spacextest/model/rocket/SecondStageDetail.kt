package com.dyckster.spacextest.model.rocket

import com.google.gson.annotations.SerializedName

data class SecondStageDetail(
        @SerializedName("engines")
        val engines: Int,
        @SerializedName("fuel_amount_tons")
        val fuelAmountTons: Float,
        @SerializedName("burn_time_sec")
        val burnTimeSeconds: Int,
        @SerializedName("thrust")
        val thrust: ForceUnit,
        @SerializedName("payloads")
        val payload: RocketPayload
)