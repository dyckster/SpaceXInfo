package com.dyckster.spacextest.data.entity.flight

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "flight")
data class FlightEntity(
        @PrimaryKey
        @ColumnInfo(name = "flight_number")
        @SerializedName("flight_number")
        var flightNumber: Int = 0,
        @ColumnInfo(name = "launch_date")
        @SerializedName("launch_date_unix")
        var launchDate: Long = 0,
        @Ignore
        @SerializedName("rocket")
        var rocketDb: RocketEntity? = null,
        @Embedded
        @SerializedName("links")
        var flightLinks: FlightLinksEntity? = null,
        @SerializedName("launch_success")
        @ColumnInfo(name = "launch_success")
        var launchSuccess: Boolean? = null,
        @Embedded
        @SerializedName("launch_site")
        var launchSite: LaunchSiteEntity? = null,
        @ColumnInfo(name = "details")
        @SerializedName("details")
        var details: String? = "")