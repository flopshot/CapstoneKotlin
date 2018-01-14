package com.seannajera.golfiq.injection.modules

import com.google.gson.Gson
import com.seannajera.golfiq.repository.YahooWeatherService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class WeatherServiceModule {

    @Provides
    fun getWindService(yahooWeatherRetrofit: Retrofit): YahooWeatherService {
        return yahooWeatherRetrofit.create<YahooWeatherService>(YahooWeatherService::class.java)
    }

    @Provides
    fun yahooWeatherRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://query.yahooapis.com/v1/public/yql")
                .build()
    }
}