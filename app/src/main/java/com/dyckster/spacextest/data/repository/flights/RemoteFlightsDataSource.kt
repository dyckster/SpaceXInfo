package com.dyckster.spacextest.data.repository.flights

import com.dyckster.spacextest.data.network.SpaceXApiService
import com.dyckster.spacextest.model.flight.Flight
import io.reactivex.Single
import io.reactivex.functions.BiFunction

object RemoteFlightsDataSource : FlightsDataSource {
    override fun getFlight(): Single<Flight> {
        TODO("not implemented")
    }

    override fun getLatestFlight() {
        TODO("not implemented")
    }

    override fun getFlights(): Single<List<Flight>> {
        val api = SpaceXApiService.instance
        return Single.zip(api.getAllFlights(), api.getUpcomingFlights(), BiFunction { t1, t2 -> t1.union(t2).toList() })
    }

    //Not used in remote data source
    override fun saveFlights(vararg flights: Flight) {}
}