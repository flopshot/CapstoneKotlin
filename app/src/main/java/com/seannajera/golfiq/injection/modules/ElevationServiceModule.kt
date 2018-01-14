package com.seannajera.golfiq.injection.modules

import com.google.gson.Gson
import com.seannajera.golfiq.repository.ElevationService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ElevationServiceModule {

    @Provides
    fun getElevationService(elevationRetrofit: Retrofit): ElevationService {
        return elevationRetrofit.create<ElevationService>(ElevationService::class.java)
    }

    @Provides
    fun usgsRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://nas.er.usgs.gov/api/v1")
                .build()
    }
}