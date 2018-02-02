package com.dyckster.spacextest.di.global

import com.dyckster.spacextest.domain.repository.FlightsRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, DataModule::class])
interface ApplicationComponent {

    fun flightsRepository(): FlightsRepository
}