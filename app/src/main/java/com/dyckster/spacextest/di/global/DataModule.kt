package com.dyckster.spacextest.di.global

import android.arch.persistence.room.Room
import android.content.Context
import android.support.annotation.NonNull
import com.dyckster.spacextest.data.db.AppDatabase
import com.dyckster.spacextest.data.network.SpaceXApiService
import com.dyckster.spacextest.data.repository.flights.FlightsRepositoryImpl
import com.dyckster.spacextest.domain.repository.FlightsRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun provideFlightsRepository(repository: FlightsRepositoryImpl): FlightsRepository = repository

    @NonNull
    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "news-db").build()

    @NonNull
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient.addInterceptor(loggingInterceptor)

        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): SpaceXApiService {
        return retrofit.create(SpaceXApiService::class.java)
    }

}