package com.dyckster.spacextest.presentation.ui.main.adapter

import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.dyckster.spacextest.R
import com.dyckster.spacextest.domain.model.flight.Flight
import com.dyckster.spacextest.presentation.ui.global.viewholders.EmptyViewHolder
import com.dyckster.spacextest.presentation.utils.GraphicUnit

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<Item> = ArrayList()
    private lateinit var aboutClickListener: () -> Unit
    private lateinit var flightClickListener: (Flight) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            ViewType.values()[viewType].viewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].viewType.ordinal

    override fun getItemId(position: Int): Long {
        if (items[position].viewType.hasStableId()) {
            return items[position].type?.hashCode()?.toLong() ?: RecyclerView.NO_ID
        }
        return RecyclerView.NO_ID
    }

    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(true)
    }

    fun setOnAboutClickListener(listener: () -> Unit) {
        aboutClickListener = listener
    }

    fun setOnFlightClickListener(listener: (Flight) -> Unit) {
        flightClickListener = listener
    }

    fun buildAdapter(flights: List<Flight>) {
        items.clear()
        flights
                .filter { it.launchDate > System.currentTimeMillis() / 1000L }
                .apply { if (isNotEmpty()) addHeader(R.string.title_flights_upcoming) }
                .forEachIndexed { index, flight ->
                    if (index == 0) items.add(Item(ViewType.FLIGHT_UPCOMING, flight))
                    else items.add(Item(ViewType.FLIGHT_UPCOMING_COMPACT, flight))
                }
                .apply { items.add(Item(ViewType.EMPTY, 8)) }
                .apply { items.add(Item(ViewType.ABOUT)) }
                .let { flights }
                .asReversed()
                .filter { it.launchDate <= System.currentTimeMillis() / 1000L }
                .apply { addHeader(R.string.title_flights_past) }
                .forEach {
                    items.add(Item(ViewType.FLIGHT_PAST, it))
                    items.add(Item(ViewType.DIVIDER))
                }
                .apply { items.add(Item(ViewType.EMPTY, 88)) }

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val obj = items[position].type
        when (holder) {
            is AbstractFlightViewHolder -> {
                holder.setFlight(obj as Flight)
                holder.setOnClickListener(flightClickListener)
            }
            is EmptyViewHolder -> holder.setHeight(obj as Int, GraphicUnit.DP)
            is HeaderViewHolder -> holder.setHeader(obj as Int)
            is AboutViewHolder -> holder.setOnClickListener(aboutClickListener)
        }
    }

    private fun addHeader(@StringRes title: Int) {
        items.add(Item(ViewType.EMPTY, 8))
        items.add(Item(ViewType.HEADER, title))
        items.add(Item(ViewType.EMPTY, 8))
    }

    private data class Item(val viewType: ViewType, val type: Any? = null)

}