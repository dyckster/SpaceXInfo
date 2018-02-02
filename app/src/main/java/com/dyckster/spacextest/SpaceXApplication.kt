package com.dyckster.spacextest

import android.app.Application
import com.dyckster.spacextest.data.network.SpaceXApiService
import com.dyckster.spacextest.di.global.ApplicationComponent
import com.dyckster.spacextest.di.global.ApplicationModule
import com.dyckster.spacextest.di.global.DaggerApplicationComponent
import com.dyckster.spacextest.di.global.DataModule

class SpaceXApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        applicationComponent = buildComponent()
    }

    private fun buildComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .dataModule(DataModule((SpaceXApiService.BASE_URL)))
                .build()
    }


    companion object {
        lateinit var applicationComponent: ApplicationComponent
            private set

        lateinit var instance: SpaceXApplication
            private set
    }
}