package com.dyckster.spacextest.presentation.ui.main.adapter

import android.view.ViewGroup
import com.dyckster.spacextest.R
import com.dyckster.spacextest.presentation.ui.global.viewholders.BaseViewHolder

internal class AboutViewHolder(parent: ViewGroup) : BaseViewHolder(R.layout.item_about, parent) {

    fun setOnClickListener(listener: () -> Unit) {
        itemView.setOnClickListener { listener.invoke() }
    }

}