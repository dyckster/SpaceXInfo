package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.model.flight.Flight
import io.reactivex.Single

interface FlightsDataSource {
    fun getLatestFlight()

    fun getFlights(): Single<List<Flight>>

    fun getFlight(): Single<Flight>

    fun saveFlights(vararg flights: Flight)
}