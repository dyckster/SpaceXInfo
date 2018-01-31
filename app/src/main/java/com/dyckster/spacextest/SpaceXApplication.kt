package com.dyckster.spacextest

import android.app.Application
import android.arch.persistence.room.Room
import com.dyckster.spacextest.data.db.AppDatabase

class SpaceXApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        SpaceXApplication.database = Room
                .databaseBuilder(this, AppDatabase::class.java, "news-db")
                .build()
    }


    companion object {
        lateinit var instance: SpaceXApplication
            private set
        lateinit var database: AppDatabase
    }
}