package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.SpaceXApplication
import com.dyckster.spacextest.data.entity.flight.FirstStageEntity
import com.dyckster.spacextest.data.entity.flight.FlightEntity
import com.dyckster.spacextest.data.entity.flight.SecondStageEntity
import com.dyckster.spacextest.data.exception.EmptyLocalDataException
import io.reactivex.Single
import io.reactivex.functions.BiFunction

internal object LocalFlightsDataSource : FlightsDataSource {


    override fun getFlights(): Single<List<FlightEntity>> {
        val flightsDao = SpaceXApplication.database.flightsDao()
        val flightsDb = flightsDao.getFlights()
        val rocketsDb = flightsDao.getRocketsWithStages()
        return Single.zip(flightsDb, rocketsDb, BiFunction { flights, rockets ->
            return@BiFunction flights
                    .onEach {
                        val flightNumber: Int = it.flightNumber
                        val rocketDbWithStages = rockets.find { flightNumber == it.rocketDb!!.flightNumber }!!
                        it.rocketDb = rocketDbWithStages.rocketDb
                        it.rocketDb!!.firstStageEntity = FirstStageEntity(rocketDbWithStages.cores)
                        it.rocketDb!!.secondStageEntity = SecondStageEntity(rocketDbWithStages.payloads)
                    }
                    .takeUnless { it.isEmpty() } ?: throw EmptyLocalDataException()
        })

    }

    override fun saveFlights(flights: List<FlightEntity>) {
        val rockets = flights.map { it.rocketDb!! }
        val cores = flights.flatMap { it.rocketDb!!.firstStageEntity!!.cores }
        val payloads = flights.flatMap { it.rocketDb!!.secondStageEntity!!.payloads }
        SpaceXApplication.database.flightsDao()
                .insertFlights(flights, rockets, cores, payloads)
    }
}