package com.dyckster.spacextest.presentation.ui.main.adapter

import android.view.ViewGroup
import com.dyckster.spacextest.R
import com.dyckster.spacextest.domain.model.flight.Flight
import kotlinx.android.synthetic.main.item_flight_upcoming.view.*
import java.text.SimpleDateFormat
import java.util.*

internal class FlightUpcomingViewHolder(parent: ViewGroup) : AbstractFlightViewHolder(R.layout.item_flight_upcoming, parent) {
    override fun setFlight(flight: Flight) {
        itemView.itemUpcomingRocket.text = flight.rocket.rocketName
        itemView.itemUpcomingTitle.text = itemView.context.getString(R.string.flight_format_no_date, flight.flightNumber.toString())
        itemView.itemUpcomingStart.text = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date(flight.launchDate * 1000L))
    }
}