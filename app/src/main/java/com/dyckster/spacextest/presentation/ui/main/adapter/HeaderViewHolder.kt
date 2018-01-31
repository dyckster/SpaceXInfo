package com.dyckster.spacextest.presentation.ui.main.adapter

import android.support.annotation.StringRes
import android.view.ViewGroup
import com.dyckster.spacextest.R
import com.dyckster.spacextest.presentation.ui.global.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_header.view.*

internal class HeaderViewHolder(parent: ViewGroup) : BaseViewHolder(R.layout.item_header, parent) {
    fun setHeader(@StringRes title: Int) {
        itemView.itemHeaderText.setText(title)
    }
}