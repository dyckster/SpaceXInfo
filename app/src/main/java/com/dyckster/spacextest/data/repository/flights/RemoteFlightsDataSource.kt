package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.data.entity.flight.FlightEntity
import com.dyckster.spacextest.data.network.SpaceXApiService
import io.reactivex.Single
import io.reactivex.functions.BiFunction

internal object RemoteFlightsDataSource : FlightsDataSource {


    override fun getFlights(): Single<List<FlightEntity>> {
        val api = SpaceXApiService.instance
        return Single.zip(api.getAllFlights(), api.getUpcomingFlights(), BiFunction { t1, t2 ->
            t1.union(t2).toList().onEach {
                val flightNumber = it.flightNumber
                it.rocketDb!!.flightNumber = flightNumber
                it.rocketDb!!.firstStageEntity!!.cores.apply { it.flightNumber = flightNumber }
                it.rocketDb!!.secondStageEntity!!.payloads.apply { it.flightNumber = flightNumber }
            }
        })
    }

    //Not used in remote data source
    override fun saveFlights(flights: List<FlightEntity>) {
    }
}