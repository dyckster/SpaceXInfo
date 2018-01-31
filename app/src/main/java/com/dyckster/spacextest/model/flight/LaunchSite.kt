package com.dyckster.spacextest.model.flight

import com.google.gson.annotations.SerializedName

data class LaunchSite(
        @SerializedName("site_id")
        val siteId: String,
        @SerializedName("site_name")
        val siteName: String,
        @SerializedName("site_name_long")
        val siteNameLong: String
)