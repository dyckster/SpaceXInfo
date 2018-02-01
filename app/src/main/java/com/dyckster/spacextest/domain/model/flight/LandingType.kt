package com.dyckster.spacextest.domain.model.flight

import android.support.annotation.StringRes
import com.dyckster.spacextest.R

enum class LandingType(@StringRes val title: Int) {
    ASDS(R.string.landing_asds),
    RTLS(R.string.landing_rtls),
    OCEAN(R.string.landing_ocean),
    NONE(R.string.landing_none);

    companion object {
        fun fromString(name: String): LandingType {
            return values().find { it.name.contentEquals(name) } ?: NONE
        }

    }
}