package com.seannajera.golfiq.injection.components

import com.seannajera.golfiq.injection.modules.WeatherServiceModule
import com.seannajera.golfiq.repository.YahooWeatherService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [WeatherServiceModule::class], dependencies = [ApplicationComponent::class])
interface WeatherComponent {
    fun inject(weatherService: YahooWeatherService)
}