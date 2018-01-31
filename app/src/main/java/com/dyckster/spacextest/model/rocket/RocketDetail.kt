package com.dyckster.spacextest.model.rocket

data class RocketDetail(
        val id: String,
        val name: String,
        val type: String,
        val active: Boolean,
        val stages: Int,
        val boosters: Int,
        val costPerLaunch: Long,
        val successRate: Int,
        val firstFlight: String,
        val country: String,
        val company: String,
        val height: InternationalizedUnit,
        val diameter: InternationalizedUnit,
        val mass: MassUnit,
        val payloadWeights: List<PayloadWeight>,
        val firstStageDetail: FirstStageDetail,
        val secondStageDetail: SecondStageDetail,
        val engine: Engine,
        val landingLegs: LandingLegs,
        val description: String

)