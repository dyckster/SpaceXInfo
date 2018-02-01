package com.dyckster.spacextest.presentation.ui.main.adapter

import android.support.annotation.LayoutRes
import android.view.ViewGroup
import com.dyckster.spacextest.domain.model.flight.Flight
import com.dyckster.spacextest.presentation.ui.global.viewholders.BaseViewHolder

internal abstract class AbstractFlightViewHolder(@LayoutRes layout: Int, parent: ViewGroup) : BaseViewHolder(layout, parent) {
    abstract fun setFlight(flight: Flight)
}