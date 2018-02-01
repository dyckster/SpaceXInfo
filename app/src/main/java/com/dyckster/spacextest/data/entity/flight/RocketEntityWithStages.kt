package com.dyckster.spacextest.data.entity.flight

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

data class RocketEntityWithStages(
        @Embedded
        var rocketDb: RocketEntity? = null,
        @Relation(parentColumn = "flight_number", entityColumn = "flight_number", entity = CoreEntity::class)
        var cores: List<CoreEntity> = ArrayList(),
        @Relation(parentColumn = "flight_number", entityColumn = "flight_number", entity = PayloadEntity::class)
        var payloads: List<PayloadEntity> = ArrayList())