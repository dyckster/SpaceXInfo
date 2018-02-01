package com.dyckster.spacextest.data.db

import android.arch.persistence.room.*
import com.dyckster.spacextest.data.entity.flight.*
import io.reactivex.Single

@Dao
abstract class FlightsDao {

    @Insert
    @Transaction
    open fun insertFlights(flights: List<FlightEntity>,
                           rockets: List<RocketEntity>,
                           cores: List<CoreEntity>,
                           payloads: List<PayloadEntity>) {
        insertFlights(flights)
        insertRockets(rockets)
        insertCores(cores)
        insertPayloads(payloads)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFlights(flights: List<FlightEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertRockets(rockets: List<RocketEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCores(cores: List<CoreEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPayloads(payloads: List<PayloadEntity>)

    @Transaction
    @Query("SELECT * FROM rocket_flight WHERE flight_number = :flightNumber")
    abstract fun getRocketWithStages(flightNumber: Int): Single<RocketEntityWithStages>

    @Query("SELECT * FROM flight WHERE flight_number = :flightNumber")
    abstract fun getFlight(flightNumber: Int): Single<FlightEntity>

    @Query("SELECT * FROM flight")
    abstract fun getFlights(): Single<List<FlightEntity>>

    @Transaction
    @Query("SELECT * FROM rocket_flight")
    abstract fun getRocketsWithStages(): Single<List<RocketEntityWithStages>>


}