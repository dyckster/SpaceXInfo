package com.dyckster.spacextest.presentation.ui.main.adapter

import android.view.View
import android.view.ViewGroup
import com.dyckster.spacextest.R
import com.dyckster.spacextest.domain.model.flight.Flight
import kotlinx.android.synthetic.main.item_flight_past.view.*
import java.text.SimpleDateFormat
import java.util.*

internal class FlightPastViewHolder(parent: ViewGroup) : AbstractFlightViewHolder(R.layout.item_flight_past, parent) {
    override fun setFlight(flight: Flight) {
        val date = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date(flight.launchDate * 1000L))
        itemView.itemPastTitle.text = itemView.context.getString(R.string.flight_format_full, flight.flightNumber.toString(), date)
        itemView.itemPastDetails.text = flight.details
        if (flight.details.isNullOrBlank()) itemView.itemPastDetails.visibility = View.GONE
        else itemView.itemPastDetails.visibility = View.VISIBLE
    }
}