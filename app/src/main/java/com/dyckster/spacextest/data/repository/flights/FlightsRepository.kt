package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.data.entity.flight.FlightEntity
import io.reactivex.Single

object FlightsRepository : FlightsDataSource {


    override fun getFlights(): Single<List<FlightEntity>> {
        return LocalFlightsDataSource.getFlights()
                .onErrorResumeNext {
                    RemoteFlightsDataSource
                            .getFlights()
                            .doOnSuccess { LocalFlightsDataSource.saveFlights(it) }
                            .doOnError {}
                }
    }

    override fun saveFlights(flights: List<FlightEntity>) {
        // Not used here
    }
}