package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.data.entity.flight.FlightEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object FlightsRepository : FlightsDataSource {


    override fun getFlights(): Single<List<FlightEntity>> {
        return LocalFlightsDataSource.getFlights()
                .onErrorResumeNext {
                    RemoteFlightsDataSource
                            .getFlights()
                            .doOnSuccess { LocalFlightsDataSource.saveFlights(it) }
                            .doOnError {}
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun saveFlights(flights: List<FlightEntity>) {
        // Not used here
    }
}