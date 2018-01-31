package com.dyckster.spacextest.model.rocket

data class Engine(
        val numberOfEngines: Int,
        val type: String,
        val version: String,
        val layout: String,
        val engineLossMax: Int,
        val firstPropellant: String,
        val secondPropellant: String,
        val thrustSeaLevel: ForceUnit,
        val thrustVacuum: ForceUnit,
        val thrustToWeight: Int
)