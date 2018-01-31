package com.dyckster.spacextest.model.flight

import com.google.gson.annotations.SerializedName

data class Rocket(
        @SerializedName("rocket_id")
        val rocketId: String,
        @SerializedName("rocket_name")
        val rocketName: String,
        @SerializedName("rocket_type")
        val rocketType: String,
        @SerializedName("first_stage")
        val firstStage: FirstStage,
        @SerializedName("second_stage")
        val secondStage: SecondStage
)