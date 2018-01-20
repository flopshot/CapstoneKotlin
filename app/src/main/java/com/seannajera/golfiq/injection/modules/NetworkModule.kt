package com.seannajera.golfiq.injection.modules

import com.seannajera.golfiq.GolfIqApplication
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    val loggingInterceptor: HttpLoggingInterceptor
        @Provides
        get() {
            val hli = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.i(message) }
            )
            return hli.setLevel(HttpLoggingInterceptor.Level.BASIC)
        }

    @Provides
    fun getCacheFile(context: GolfIqApplication): File {
        return File(context.getCacheDir(), "okhttp-cache")
    }

    @Provides
    fun getOkHttpCache(cacheFile: File): Cache {
        return Cache(cacheFile, 10 * 1000 * 1000)
    }

    @Provides
    fun getOkHttpClient(cache: Cache, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
    }
}