package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.model.flight.Flight
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object FlightsRepository : FlightsDataSource {
    override fun getFlight(): Single<Flight> {
        TODO("not implemented")
    }

    override fun getLatestFlight() {
        TODO("not implemented")
    }

    override fun getFlights(): Single<List<Flight>> {
        return LocalFlightsDataSource.getFlights()
                .onErrorResumeNext {
                    RemoteFlightsDataSource
                            .getFlights()
                            .doOnSuccess { LocalFlightsDataSource.saveFlights(*it.toTypedArray()) }
                            .doOnError {}
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }

    // Not used here
    override fun saveFlights(vararg flights: Flight) {}

}