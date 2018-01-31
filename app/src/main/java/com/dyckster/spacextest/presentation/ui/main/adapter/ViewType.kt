package com.dyckster.spacextest.presentation.ui.main.adapter

import android.view.ViewGroup
import com.dyckster.spacextest.presentation.ui.global.viewholders.BaseViewHolder
import com.dyckster.spacextest.presentation.ui.global.viewholders.DividerViewHolder
import com.dyckster.spacextest.presentation.ui.global.viewholders.EmptyViewHolder

internal enum class ViewType {
    FLIGHT_PAST {
        override fun hasStableId(): Boolean = true

        override fun viewHolder(parent: ViewGroup): BaseViewHolder = FlightPastViewHolder(parent)
    },
    FLIGHT_UPCOMING {
        override fun hasStableId(): Boolean = true

        override fun viewHolder(parent: ViewGroup): BaseViewHolder = FlightUpcomingViewHolder(parent)
    },
    FLIGHT_UPCOMING_COMPACT {
        override fun hasStableId(): Boolean = true

        override fun viewHolder(parent: ViewGroup): BaseViewHolder = FlightUpcomingCompactViewHolder(parent)
    },
    HEADER {
        override fun hasStableId(): Boolean = true

        override fun viewHolder(parent: ViewGroup): BaseViewHolder = HeaderViewHolder(parent)
    },
    EMPTY {
        override fun hasStableId(): Boolean = false

        override fun viewHolder(parent: ViewGroup): BaseViewHolder = EmptyViewHolder(parent)
    },
    DIVIDER {
        override fun hasStableId(): Boolean = false

        override fun viewHolder(parent: ViewGroup): BaseViewHolder = DividerViewHolder(parent)
    };

    abstract fun viewHolder(parent: ViewGroup): BaseViewHolder

    abstract fun hasStableId(): Boolean
}