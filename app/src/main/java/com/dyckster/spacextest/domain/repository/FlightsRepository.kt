package com.dyckster.spacextest.domain.repository

import com.dyckster.spacextest.data.entity.flight.FlightEntity
import io.reactivex.Single

interface FlightsRepository {

    fun getFlights(): Single<List<FlightEntity>>

    fun getFlightsLocally(): Single<List<FlightEntity>>

    fun getFlightsRemotely(): Single<List<FlightEntity>>

    fun saveFlights(flights: List<FlightEntity>)
}