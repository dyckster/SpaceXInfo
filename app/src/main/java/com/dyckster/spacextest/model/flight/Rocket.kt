package com.dyckster.spacextest.model.flight

data class Rocket(
        val rocketId: String,
        val rocketName: String,
        val rocketType: String,
        val firstStage: FirstStage,
        val secondStage: SecondStage
)