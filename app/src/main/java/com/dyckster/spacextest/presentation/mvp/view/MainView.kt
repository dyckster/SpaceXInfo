package com.dyckster.spacextest.presentation.mvp.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.dyckster.spacextest.domain.model.flight.Flight

interface MainView : MvpView {
    fun showFlights(flights: List<Flight>)

    @StateStrategyType(SkipStrategy::class)
    fun showProgressView(show: Boolean)

    @StateStrategyType(SkipStrategy::class)
    fun openAbout()

    @StateStrategyType(SkipStrategy::class)
    fun openFlight(flight: Flight)
}