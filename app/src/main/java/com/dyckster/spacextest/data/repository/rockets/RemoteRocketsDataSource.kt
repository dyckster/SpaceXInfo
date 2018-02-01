package com.dyckster.spacextest.data.repository.rockets

import com.dyckster.spacextest.model.rocket.RocketDetail
import io.reactivex.Single

object RemoteRocketsDataSource:RocketsDataSource {
    override fun getRockets(): Single<List<RocketDetail>> {
        TODO("not implemented")
    }

    override fun getRocket(rocketId: String): Single<RocketDetail> {
        TODO("not implemented")
    }
}