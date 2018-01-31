package com.dyckster.spacextest.presentation.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.dyckster.spacextest.R
import com.dyckster.spacextest.data.repository.flights.FlightsRepository
import com.dyckster.spacextest.model.flight.Flight
import com.dyckster.spacextest.presentation.mvp.presenter.MainPresenter
import com.dyckster.spacextest.presentation.mvp.view.MainView
import com.dyckster.spacextest.presentation.ui.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = MainPresenter(FlightsRepository)

    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchesRecyclerView.layoutManager = LinearLayoutManager(this)
        launchesRecyclerView.adapter = adapter

        launchesSwipeRefresh.setOnRefreshListener { presenter.fetchFlights(true) }
        launchesFilterButton.setOnClickListener { Toast.makeText(this, "Not working yet", Toast.LENGTH_LONG).show() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.main_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.main_settings -> {
                Toast.makeText(this, "Not working yet", Toast.LENGTH_LONG).show()
                true
            }
            else -> false
        }
    }

    override fun showProgressView(show: Boolean) {
        launchesSwipeRefresh.isRefreshing = show
    }

    override fun showFlights(flights: List<Flight>) {
        adapter.buildAdapter(flights)
    }

}
