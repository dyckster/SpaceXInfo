package com.dyckster.spacextest.data.db

import android.arch.persistence.room.*
import com.dyckster.spacextest.model.flight.db.*
import io.reactivex.Single

@Dao
abstract class FlightsDao {

    @Insert
    @Transaction
    open fun insertFlights(flights: List<FlightDb>,
                           rockets: List<RocketDb>,
                           cores: List<CoreDb>,
                           payloads: List<PayloadDb>) {
        insertFlights(flights)
        insertRockets(rockets)
        insertCores(cores)
        insertPayloads(payloads)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFlights(flights: List<FlightDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertRockets(rockets: List<RocketDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCores(cores: List<CoreDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPayloads(payloads: List<PayloadDb>)

    @Transaction
    @Query("SELECT * FROM flight_rocket WHERE flight_number = :flightNumber")
    abstract fun getRocketWithStages(flightNumber: Int): Single<RocketDbWithStages>

    @Query("SELECT * FROM flight WHERE flight_number = :flightNumber")
    abstract fun getFlight(flightNumber: Int): Single<FlightDb>

    @Query("SELECT * FROM flight")
    abstract fun getFlights(): Single<List<FlightDb>>

    @Transaction
    @Query("SELECT * FROM flight_rocket")
    abstract fun getRocketsWithStages(): Single<List<RocketDbWithStages>>


}