package com.dyckster.spacextest.domain.model.rocket

import com.google.gson.annotations.SerializedName

data class Engine(
        @SerializedName("number")
        val numberOfEngines: Int,
        @SerializedName("type")
        val type: String,
        @SerializedName("version")
        val version: String,
        @SerializedName("layout")
        val layout: String,
        @SerializedName("engine_loss_max")
        val engineLossMax: Int,
        @SerializedName("propellant_1")
        val firstPropellant: String,
        @SerializedName("propellant_2")
        val secondPropellant: String,
        @SerializedName("thrust_sea_level")
        val thrustSeaLevel: ForceUnit,
        @SerializedName("thrust_vacuum")
        val thrustVacuum: ForceUnit,
        @SerializedName("thrust_to_weight")
        val thrustToWeight: Int
)