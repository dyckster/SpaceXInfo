package com.dyckster.spacextest.data.network

import com.dyckster.spacextest.data.entity.flight.FlightEntity
import com.dyckster.spacextest.domain.model.info.CompanyInfo
import com.dyckster.spacextest.domain.model.rocket.RocketDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXApiService {
    @GET("launches")
    fun getAllFlights(): Single<List<FlightEntity>>

    @GET("launches/upcoming")
    fun getUpcomingFlights(): Single<List<FlightEntity>>

    @GET("rockets")
    fun getRockets(): Single<List<RocketDetail>>

    @GET("rockets/{id}")
    fun getRocket(@Path("id") rocketId: String): Single<RocketDetail>

    @GET("info")
    fun getCompanyData(): Single<CompanyInfo>

    @GET("launchpads")
    fun getLaunchpads()

    companion object {
        const val BASE_URL = "https://api.spacexdata.com/v2/"
    }

}