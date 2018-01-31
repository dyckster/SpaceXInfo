package com.dyckster.spacextest.data.network

import com.dyckster.spacextest.model.flight.Flight
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SpaceXApiService {
    @GET("launches")
    fun getAllFlights(): Single<List<Flight>>

    @GET("launches/upcoming")
    fun getUpcomingFlights(): Single<List<Flight>>

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