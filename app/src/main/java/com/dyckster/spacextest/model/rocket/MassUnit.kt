package com.dyckster.spacextest.model.rocket

import com.google.gson.annotations.SerializedName

data class MassUnit(
        @SerializedName("kg")
        val kg: Float,
        @SerializedName("lb")
        val lb: Float
)
