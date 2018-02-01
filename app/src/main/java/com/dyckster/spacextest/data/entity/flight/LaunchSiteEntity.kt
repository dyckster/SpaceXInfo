package com.dyckster.spacextest.data.entity.flight

import com.google.gson.annotations.SerializedName

data class LaunchSiteEntity(
        @SerializedName("site_id")
        var siteId: String,
        @SerializedName("site_name")
        var siteName: String,
        @SerializedName("site_name_long")
        var siteNameLong: String
)