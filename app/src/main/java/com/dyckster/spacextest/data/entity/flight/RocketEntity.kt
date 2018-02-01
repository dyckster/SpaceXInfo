package com.dyckster.spacextest.data.entity.flight

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "rocket_flight")
data class RocketEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo(name = "rocket_id")
        @SerializedName("rocket_id")
        var rocketId: String = "",
        @ColumnInfo(name = "flight_number")
        var flightNumber: Int = 0,
        @SerializedName("rocket_name")
        @ColumnInfo(name = "rocket_name")
        var rocketName: String = "",
        @SerializedName("rocket_type")
        @ColumnInfo(name = "rocket_type")
        var rocketType: String = "",
        @Ignore
        @SerializedName("first_stage")
        var firstStageEntity: FirstStageEntity? = null,
        @Ignore
        @SerializedName("second_stage")
        var secondStageEntity: SecondStageEntity? = null
)