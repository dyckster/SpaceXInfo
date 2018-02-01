package com.dyckster.spacextest.presentation.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dyckster.spacextest.data.entity.flight.FlightEntity
import com.dyckster.spacextest.data.mapper.FlightMapper
import com.dyckster.spacextest.data.repository.flights.FlightsRepository
import com.dyckster.spacextest.presentation.mvp.view.MainView

@InjectViewState
class MainPresenter(private val repository: FlightsRepository) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        fetchFlights()
    }

    fun fetchFlights(forced: Boolean = false) {
        repository.getFlights()
                .doOnSubscribe { viewState.showProgressView(true) }
                .doAfterTerminate { viewState.showProgressView(false) }
                .subscribe { flights: List<FlightEntity>?, error: Throwable? ->
                    viewState.showFlights(flights?.map { FlightMapper().transform(it) }
                            ?: emptyList())
                }
    }
}