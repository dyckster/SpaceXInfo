package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.SpaceXApplication
import com.dyckster.spacextest.model.flight.Core
import com.dyckster.spacextest.model.flight.Flight
import com.dyckster.spacextest.model.flight.Payload
import com.dyckster.spacextest.model.flight.db.CoreDb
import com.dyckster.spacextest.model.flight.db.FlightDb
import com.dyckster.spacextest.model.flight.db.PayloadDb
import com.dyckster.spacextest.model.flight.db.RocketDb
import io.reactivex.Single
import io.reactivex.functions.BiFunction

object LocalFlightsDataSource : FlightsDataSource {
    override fun getFlight(): Single<Flight> {
        TODO("not implemented")
    }

    override fun getLatestFlight() {
        TODO("not implemented")
    }

    override fun getFlights(): Single<List<Flight>> {
        val flightsDao = SpaceXApplication.database.flightsDao()
        val flightsDb = flightsDao.getFlights()
        val rocketsDb = flightsDao.getRocketsWithStages()
        return Single.zip(flightsDb, rocketsDb, BiFunction { fl, rs ->
            val flights: MutableList<Flight> = ArrayList()
            fl.forEach {
                val flightNumber: Int = it.flightNumber
                val rocketDbWithStages = rs.findLast { flightNumber == it.rocketDb!!.flightNumber }!!
                flights.add(Flight(it,
                        rocketDbWithStages.rocketDb!!,
                        rocketDbWithStages.cores.map { Core(it) },
                        rocketDbWithStages.payloads.map { Payload(it) }))
            }
            if (flights.isEmpty()) throw Exception()
            return@BiFunction flights
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