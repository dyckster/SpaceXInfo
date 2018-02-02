package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.data.db.AppDatabase
import com.dyckster.spacextest.data.entity.flight.FirstStageEntity
import com.dyckster.spacextest.data.entity.flight.FlightEntity
import com.dyckster.spacextest.data.entity.flight.SecondStageEntity
import com.dyckster.spacextest.data.exception.EmptyLocalDataException
import com.dyckster.spacextest.data.network.SpaceXApiService
import com.dyckster.spacextest.domain.repository.FlightsRepository
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class FlightsRepositoryImpl
@Inject constructor(private val apiService: SpaceXApiService, private val database: AppDatabase) : FlightsRepository {

    override fun getFlights(): Single<List<FlightEntity>> {
        return getFlightsLocally()
                .onErrorResumeNext {
                    getFlightsRemotely()
                            .doOnSuccess { saveFlights(it) }
                            .doOnError {}
                }
    }

    override fun getFlightsLocally(): Single<List<FlightEntity>> {
        val flightsDao = database.flightsDao()
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

    override fun getFlightsRemotely(): Single<List<FlightEntity>> {
        return Single.zip(apiService.getAllFlights(), apiService.getUpcomingFlights(), BiFunction { t1, t2 ->
            t1.union(t2).toList().onEach {
                val flightNumber = it.flightNumber
                it.rocketDb!!.flightNumber = flightNumber
                it.rocketDb!!.firstStageEntity!!.cores.apply { it.flightNumber = flightNumber }
                it.rocketDb!!.secondStageEntity!!.payloads.apply { it.flightNumber = flightNumber }
            }
        })
    }

    override fun saveFlights(flights: List<FlightEntity>) {
        val rockets = flights.map { it.rocketDb!! }
        val cores = flights.flatMap { it.rocketDb!!.firstStageEntity!!.cores }
        val payloads = flights.flatMap { it.rocketDb!!.secondStageEntity!!.payloads }
        database.flightsDao()
                .insertFlights(flights, rockets, cores, payloads)
    }
}