package com.dyckster.spacextest.model.rocket

data class FirstStageDetail(
        val reusable: Boolean,
        val engines: Int,
        val fuelAmountTons: Float,
        val burnTimeSec: Int,
        val seaLevelThrust: ForceUnit,
        val thrustVacuum: ForceUnit
)