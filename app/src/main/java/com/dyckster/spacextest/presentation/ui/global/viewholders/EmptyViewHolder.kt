package com.dyckster.spacextest.presentation.ui.global.viewholders

import android.view.ViewGroup
import com.dyckster.spacextest.R
import com.dyckster.spacextest.presentation.utils.DpUtil
import com.dyckster.spacextest.presentation.utils.GraphicUnit

class EmptyViewHolder(parent: ViewGroup) : BaseViewHolder(R.layout.item_empty, parent) {

    fun setHeight(height: Int, unit: GraphicUnit) {
        val params = itemView.layoutParams
        params.height = when (unit) {
            GraphicUnit.DP -> DpUtil.dpToPx(height)
            GraphicUnit.PX -> height
        }
        itemView.requestLayout()
    }

}