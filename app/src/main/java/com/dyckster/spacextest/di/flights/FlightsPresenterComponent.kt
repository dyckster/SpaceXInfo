package com.dyckster.spacextest.di.flights

import com.dyckster.spacextest.di.global.ApplicationComponent
import com.dyckster.spacextest.di.global.scopes.Presenter
import com.dyckster.spacextest.presentation.mvp.presenter.MainPresenter
import dagger.Component

@Presenter
@Component(dependencies = [ApplicationComponent::class], modules = [FlightsPresenterModule::class])
interface FlightsPresenterComponent {

    fun getPresenter(): MainPresenter

}