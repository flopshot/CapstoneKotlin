package com.seannajera.golfiq.injection.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides

@Module
class GsonModule {
    @Provides
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        //        gsonBuilder.registerTypeAdapter();
        return gsonBuilder.create()
    }
}