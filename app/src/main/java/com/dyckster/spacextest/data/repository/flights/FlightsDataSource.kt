package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.model.flight.Flight
import io.reactivex.Single

interface FlightsDataSource {

    fun getFlights(): Single<List<Flight>>

    fun saveFlights(vararg flights: Flight)
}