package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.data.entity.flight.FlightEntity
import io.reactivex.Single

interface FlightsDataSource {

    fun getFlights(): Single<List<FlightEntity>>

    fun saveFlights(flights: List<FlightEntity>)
}