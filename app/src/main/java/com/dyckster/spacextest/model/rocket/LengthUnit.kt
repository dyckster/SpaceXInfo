package com.dyckster.spacextest.model.rocket

import com.google.gson.annotations.SerializedName

data class LengthUnit(
        @SerializedName("meters")
        val meters: Float,
        @SerializedName("feet")
        val feet: Float
)