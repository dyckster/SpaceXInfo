package com.dyckster.spacextest.presentation.ui.main.adapter

import android.view.ViewGroup
import com.dyckster.spacextest.R
import com.dyckster.spacextest.model.flight.Flight
import kotlinx.android.synthetic.main.item_flight_past.view.*

internal class FlightPastViewHolder(parent: ViewGroup) : AbstractFlightViewHolder(R.layout.item_flight_past, parent) {
    override fun setFlight(flight: Flight) {
        itemView.itemPastTitle.text = itemView.context.getString(R.string.flight_format_full, flight.flightNumber.toString(), flight.launchDate.toString())
        itemView.itemPastDetails.text = flight.details
    }
}