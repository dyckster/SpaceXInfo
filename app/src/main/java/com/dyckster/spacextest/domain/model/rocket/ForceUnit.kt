package com.dyckster.spacextest.domain.model.rocket

import com.google.gson.annotations.SerializedName

data class ForceUnit(
        @SerializedName("kN")
        val newtons: Float,
        @SerializedName("lbf")
        val poundForce: Float
)
