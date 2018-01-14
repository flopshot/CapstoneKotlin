package com.seannajera.golfiq.injection.components

import com.seannajera.golfiq.injection.modules.ElevationServiceModule
import com.seannajera.golfiq.repository.ElevationService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ElevationServiceModule::class], dependencies = [ApplicationComponent::class])
interface ElevationComponent {
    fun inject(elevationWeatherService: ElevationService)
}