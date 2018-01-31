package com.dyckster.spacextest.model.rocket

data class SecondStageDetail(
        val engines: Int,
        val fuelAmountTons: Float,
        val burnTimeSeconds: Int,
        val thrust: ForceUnit,
        val payload: RocketPayload
)