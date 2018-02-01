package com.dyckster.spacextest.domain.model.rocket

import com.google.gson.annotations.SerializedName

data class LandingLegs(
        @SerializedName("number")
        val numberOfLegs: Int,
        @SerializedName("material")
        val material: String?
)