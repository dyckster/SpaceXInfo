package com.dyckster.spacextest.model.rocket

import com.google.gson.annotations.SerializedName

data class PayloadWeight(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("kg")
        val kg: Float,
        @SerializedName("lb")
        val lb: Float
)