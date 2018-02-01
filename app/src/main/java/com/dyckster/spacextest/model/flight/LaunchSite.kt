package com.dyckster.spacextest.model.flight

import com.google.gson.annotations.SerializedName

data class LaunchSite(
        val siteId: String,
        val siteName: String,
        val siteNameLong: String
)