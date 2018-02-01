package com.dyckster.spacextest.presentation.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dyckster.spacextest.domain.interactors.FlightListInteractor
import com.dyckster.spacextest.domain.model.flight.Flight
import com.dyckster.spacextest.presentation.mvp.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers

@InjectViewState
class MainPresenter(private val interactor: FlightListInteractor) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        fetchFlights()
    }

    fun fetchFlights(forced: Boolean = false) {
        interactor.getFlights()
                .doOnSubscribe { viewState.showProgressView(true) }
                .doAfterTerminate { viewState.showProgressView(false) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { flights: List<Flight>?, error: Throwable? ->
                    viewState.showFlights(flights!!)
                }
    }
}