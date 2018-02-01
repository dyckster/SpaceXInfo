package com.dyckster.spacextest.data.repository.rockets

import com.dyckster.spacextest.domain.model.rocket.RocketDetail
import io.reactivex.Single

interface RocketsDataSource {
    fun getRocket(rocketId: String): Single<RocketDetail>

    fun getRockets(): Single<List<RocketDetail>>
}