package com.dyckster.spacextest.presentation.mvp.view

import com.arellomobile.mvp.MvpView
import com.dyckster.spacextest.domain.model.flight.Flight

interface MainView : MvpView {
    fun showFlights(flights: List<Flight>)

    fun showProgressView(show: Boolean)
}