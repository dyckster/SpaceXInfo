package com.dyckster.spacextest.data.repository.rockets

import com.dyckster.spacextest.domain.model.rocket.RocketDetail
import io.reactivex.Single

object RocketsRepository :RocketsDataSource{
    override fun getRocket(rocketId: String): Single<RocketDetail> {
        TODO("not implemented")
    }

    override fun getRockets(): Single<List<RocketDetail>> {
        TODO("not implemented")
    }
}