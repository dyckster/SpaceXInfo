package com.dyckster.spacextest.model.rocket

import com.google.gson.annotations.SerializedName

data class RocketPayload(
        @SerializedName("option_1")
        val option: String,
        @SerializedName("composite_fairing")
        val compositeFairing: CompositeFairing
)