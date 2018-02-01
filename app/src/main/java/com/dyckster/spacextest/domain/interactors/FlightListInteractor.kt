package com.dyckster.spacextest.domain.interactors

import com.dyckster.spacextest.data.mapper.FlightMapper
import com.dyckster.spacextest.data.repository.flights.FlightsDataSource
import com.dyckster.spacextest.domain.model.flight.Flight
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class FlightListInteractor(val repository: FlightsDataSource) {

    fun getFlights(forced: Boolean = false): Single<List<Flight>> {
        return repository.getFlights()
                .map { it.map { FlightMapper().transform(it) } }
                .subscribeOn(Schedulers.io())
    }
}