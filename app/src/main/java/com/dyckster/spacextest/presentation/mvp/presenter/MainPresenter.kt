package com.dyckster.spacextest.presentation.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dyckster.spacextest.data.repository.flights.FlightsRepository
import com.dyckster.spacextest.presentation.mvp.view.MainView

@InjectViewState
class MainPresenter(val repository: FlightsRepository) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        fetchFlights()
    }

    fun fetchFlights(forced: Boolean = false) {

    }
}