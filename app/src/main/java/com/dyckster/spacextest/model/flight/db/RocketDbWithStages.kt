package com.dyckster.spacextest.model.flight.db

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

data class RocketDbWithStages(
        @Embedded
        var rocketDb: RocketDb? = null,
        @Relation(parentColumn = "flight_number", entityColumn = "flight_number", entity = CoreDb::class)
        var cores: List<CoreDb> = ArrayList(),
        @Relation(parentColumn = "flight_number", entityColumn = "flight_number", entity = PayloadDb::class)
        var payloads: List<PayloadDb> = ArrayList())