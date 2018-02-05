package com.dyckster.spacextest.presentation.ui.main.adapter

import android.support.annotation.LayoutRes
import android.view.ViewGroup
import com.dyckster.spacextest.domain.model.flight.Flight
import com.dyckster.spacextest.presentation.ui.global.viewholders.BaseViewHolder

internal abstract class AbstractFlightViewHolder(@LayoutRes layout: Int, parent: ViewGroup) : BaseViewHolder(layout, parent) {

    private lateinit var listener: (Flight) -> Unit

    open fun setFlight(flight: Flight) {
        itemView.setOnClickListener { listener.invoke(flight) }
    }

    fun setOnClickListener(listener: (Flight) -> Unit) {
        this.listener = listener
    }
}