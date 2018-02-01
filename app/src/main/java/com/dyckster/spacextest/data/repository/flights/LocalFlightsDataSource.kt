package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.SpaceXApplication
import com.dyckster.spacextest.model.flight.Core
import com.dyckster.spacextest.model.flight.Flight
import com.dyckster.spacextest.model.flight.Payload
import com.dyckster.spacextest.data.entity.flight.CoreDb
import com.dyckster.spacextest.data.entity.flight.FlightDb
import com.dyckster.spacextest.data.entity.flight.PayloadDb
import com.dyckster.spacextest.data.entity.flight.RocketDb
import io.reactivex.Single
import io.reactivex.functions.BiFunction

object LocalFlightsDataSource : FlightsDataSource {

    override fun getFlights(): Single<List<Flight>> {
        val flightsDao = SpaceXApplication.database.flightsDao()
        val flightsDb = flightsDao.getFlights()
        val rocketsDb = flightsDao.getRocketsWithStages()
        return Single.zip(flightsDb, rocketsDb, BiFunction { flights, rockets ->
            return@BiFunction flights.map {
                val flightNumber: Int = it.flightNumber
                val rocketDbWithStages = rockets.find { flightNumber == it.rocketDb!!.flightNumber }!!
                return@map Flight(it,
                        rocketDbWithStages.rocketDb!!,
                        rocketDbWithStages.cores.map { Core(it) },
                        rocketDbWithStages.payloads.map { Payload(it) })
            }.takeUnless { it.isEmpty() } ?: throw Exception()
        })
    }

    override fun saveFlights(vararg flights: Flight) {
        val flightsDb = flights.map { FlightDb(it) }
        val rockets = flights.map { RocketDb(it) }
        val cores = flights.flatMap {
            val flightNumber = it.flightNumber
            it.rocket.firstStage.cores.map { CoreDb(it, flightNumber) }
        }
        val payloads = flights.flatMap {
            val flightNumber = it.flightNumber
            it.rocket.secondStage.payloads.map { PayloadDb(it, flightNumber) }
        }
        SpaceXApplication.database.flightsDao().insertFlights(flightsDb, rockets, cores, payloads)
    }
}