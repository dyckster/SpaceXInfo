package com.dyckster.spacextest.data.network

import com.dyckster.spacextest.data.entity.flight.FlightEntity
import com.dyckster.spacextest.model.flight.Flight
import com.dyckster.spacextest.model.info.CompanyInfo
import com.dyckster.spacextest.model.rocket.RocketDetail
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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

        val instance by lazy { this.create() }

        private const val BASE_URL = "https://api.spacexdata.com/v2/"

        private fun create(): SpaceXApiService {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
            client.addInterceptor(loggingInterceptor)

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(client.build())
                    .build()

            return retrofit.create(SpaceXApiService::class.java)

        }
    }

}