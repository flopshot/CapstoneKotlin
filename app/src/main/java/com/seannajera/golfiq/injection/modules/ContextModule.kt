package com.seannajera.golfiq.injection.modules

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(@get:Provides
                    val context: Context)