package com.dyckster.spacextest.presentation.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.dyckster.spacextest.R
import com.dyckster.spacextest.data.repository.flights.FlightsRepository
import com.dyckster.spacextest.model.flight.Flight
import com.dyckster.spacextest.presentation.ui.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchesRecyclerView.layoutManager = LinearLayoutManager(this)
        launchesRecyclerView.adapter = adapter

        getFlights()
    }

    private fun getFlights() {
        FlightsRepository.getFlights()
                .doOnSubscribe { launchesProgressBar.show() }
                .doAfterTerminate { launchesProgressBar.hide() }
                .subscribe { flights: List<Flight>?, _: Throwable? ->
                    adapter.buildAdapter(flights!!)
                }
    }

}
