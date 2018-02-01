package com.dyckster.spacextest.data.mapper

import com.dyckster.spacextest.data.entity.flight.FlightEntity
import com.dyckster.spacextest.data.entity.flight.FlightLinksEntity
import com.dyckster.spacextest.data.entity.flight.LaunchSiteEntity
import com.dyckster.spacextest.data.entity.flight.RocketEntity
import com.dyckster.spacextest.domain.model.flight.*

class FlightMapper : Mapper<FlightEntity, Flight> {

    override fun transform(input: FlightEntity): Flight {
        return Flight(
                input.flightNumber,
                input.launchDate,
                getRocket(input.rocketDb!!),
                getFlightLinks(input.flightLinks!!),
                input.launchSuccess,
                getLaunchSite(input.launchSite!!),
                input.details
        )
    }

    private fun getRocket(input: RocketEntity): Rocket {
        return Rocket(
                input.rocketId,
                input.rocketName,
                input.rocketType,
                getFirstStage(input),
                getSecondStage(input)
        )
    }

    private fun getFlightLinks(input: FlightLinksEntity): FlightLinks {
        return FlightLinks(
                input.missionPatch,
                input.redditCampaign,
                input.redditLaunch,
                input.redditRecovery,
                input.redditMedia,
                input.pressKit,
                input.articleLink,
                input.videoLink
        )
    }

    private fun getLaunchSite(input: LaunchSiteEntity): LaunchSite {
        return LaunchSite(
                input.siteId,
                input.siteName,
                input.siteNameLong
        )
    }

    private fun getFirstStage(input: RocketEntity): FirstStage {
        return FirstStage(input.firstStageEntity!!.cores.map {
            Core(
                    it.serial,
                    it.reused,
                    it.successfulLanding,
                    it.landingType,
                    it.landingVehicle)
        })
    }

    private fun getSecondStage(input: RocketEntity): SecondStage {
        return SecondStage(input.secondStageEntity!!.payloads.map {
            Payload(
                    it.payloadId,
                    it.capSerial,
                    it.reused,
                    it.customers,
                    it.payloadType,
                    it.payloadMassKg,
                    it.payloadMassLbs,
                    it.orbit,
                    it.massReturnedKg,
                    it.massReturnedLbs,
                    it.flightTimeSeconds,
                    it.cargoManifestLink
            )
        })

    }

}